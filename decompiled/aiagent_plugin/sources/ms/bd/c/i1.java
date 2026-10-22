package ms.bd.c;

import android.content.Context;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final HashSet f39522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final g1.b f39523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final g1.a f39524c;

    public i1(g1.b r3, d r4) {
        g1.b r5 = (g1.b) ZeusTransformUtils.wrapperContextForParams(r3, g1.b.class, "com.obric.aiagent.plugin");
        this.f39522a = new HashSet();
        this.f39523b = r5;
        this.f39524c = r4;
    }

    public final void a(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L17;
        if (r5 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L15;
        String.format(Locale.US, "Beginning load of %s...", new Object[]{r5});
        a(r6, r5, null);
        return;
    L15:
        throw new IllegalArgumentException("Given library is either null or empty");
    L7:
        if (r5.length() == 0) goto L10;
        r2 = false;
        goto L11
    L17:
        throw new IllegalArgumentException("Given context is null");
    }

    private void a(Context r17, String r18, String r19) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.aiagent.plugin");
        if (this.f39522a.contains(r18) == false) goto L68;
        String.format(Locale.US, "%s already loaded previously!", new Object[]{r18});
        return;
    L68:
        ((x1) ZeusTransformUtils.preCheckCast(this.f39523b, x1.class, "com.obric.aiagent.plugin")).getClass();     // Catch: UnsatisfiedLinkError -> L9
        System.loadLibrary(r18);     // Catch: UnsatisfiedLinkError -> L9
        this.f39522a.add(r18);     // Catch: UnsatisfiedLinkError -> L9
        String.format(Locale.US, "%s (%s) was loaded normally!", new Object[]{r18, r19});     // Catch: UnsatisfiedLinkError -> L9
        return;
    L9:
        e = move-exception;
        Object[] r1 = {Log.getStackTraceString(e)};
        Locale r0 = Locale.US;
        String.format(r0, "Loading the library normally failed: %s", r1);
        String.format(r0, "%s (%s) was not loaded normally, re-linking...", new Object[]{r18, r19});
        ((x1) ZeusTransformUtils.preCheckCast(this.f39523b, x1.class, "com.obric.aiagent.plugin")).getClass();
        if (r18.startsWith("lib") == true) goto L13;
    L15:
        String r3 = System.mapLibraryName(r18);
    L16:
        if (r19 != null) goto L18;
    L21:
        boolean r4 = true;
    L23:
        if (r4 == false) goto L25;
        File r5 = new File(r2.getDir("lib", 0), r3);
    L26:
        File r14 = r5;
        if (r14.exists() == true) goto L66;
        File r6 = r2.getDir("lib", 0);
        ((x1) ZeusTransformUtils.preCheckCast(this.f39523b, x1.class, "com.obric.aiagent.plugin")).getClass();
        if (r18.startsWith("lib") == true) goto L32;
    L34:
        String r7 = System.mapLibraryName(r18);
    L35:
        if (r19 != null) goto L37;
    L40:
        boolean r8 = true;
    L41:
        if (r8 == false) goto L43;
        File r9 = new File(r2.getDir("lib", 0), r7);
    L44:
        ((x1) ZeusTransformUtils.preCheckCast(this.f39523b, x1.class, "com.obric.aiagent.plugin")).getClass();
        if (r18.startsWith("lib") == true) goto L47;
    L49:
        String r10 = System.mapLibraryName(r18);
    L50:
        File[] r11 = r6.listFiles(new h1(r10));
        if (r11 == null) goto L59;
        int r12 = r11.length;
        int r13 = 0;
    L54:
        if (r13 >= r12) goto L59;
        File r15 = r11[r13];
        if (r15.getAbsolutePath().equals(r9.getAbsolutePath()) == true) goto L58;
        r15.delete();
    L58:
        r13 = r13 + 1;
    L59:
        g1.a r16 = this.f39524c;
        String[] r20 = ((x1) ZeusTransformUtils.preCheckCast(this.f39523b, x1.class, "com.obric.aiagent.plugin")).a();
        ((x1) ZeusTransformUtils.preCheckCast(this.f39523b, x1.class, "com.obric.aiagent.plugin")).getClass();
        if (r18.startsWith("lib") == true) goto L62;
    L64:
        String r21 = System.mapLibraryName(r18);
    L65:
        ((d) ZeusTransformUtils.preCheckCast(r16, d.class, "com.obric.aiagent.plugin")).a(r2, r20, r21, r14, this);
        goto L66
    L62:
        if (r18.endsWith(".so") == false) goto L64;
        r21 = r18;
        goto L65
    L47:
        if (r18.endsWith(".so") == false) goto L49;
        r10 = r18;
        goto L50
    L43:
        r9 = new File(r2.getDir("lib", 0), r7 + "." + r19);
        goto L44
    L37:
        if (r19.length() == 0) goto L40;
        r8 = false;
        goto L41
    L32:
        if (r18.endsWith(".so") == false) goto L34;
        r7 = r18;
    L66:
        g1.b r22 = this.f39523b;
        String r23 = r14.getAbsolutePath();
        ((x1) ZeusTransformUtils.preCheckCast(r22, x1.class, "com.obric.aiagent.plugin")).getClass();
        System.load(r23);
        this.f39522a.add(r18);
        String.format(Locale.US, "%s (%s) was re-linked!", new Object[]{r18, r19});
        return;
    L25:
        r5 = new File(r2.getDir("lib", 0), r3 + "." + r19);
        goto L26
    L18:
        if (r19.length() == 0) goto L21;
        r4 = false;
        goto L23
    L13:
        if (r18.endsWith(".so") == false) goto L15;
        r3 = r18;
        goto L16
    }
}
