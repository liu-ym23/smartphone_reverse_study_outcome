package com.stepos.ailauncher.sheet;

import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001\u0010BG\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010\u0013R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\n\u0010 R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b#\u0010\u0013R\u0011\u0010%\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b$\u0010\u0013¨\u0006'"}, d2 = {"Lcom/stepos/ailauncher/sheet/d0;", "", "Lcom/stepos/ailauncher/sheet/SheetHeightMode;", "heightMode", "", "layer", "", "forceFullOnStacked", "", "rootToken", "isRootPanel", "visualStackRoot", "<init>", "(Lcom/stepos/ailauncher/sheet/SheetHeightMode;IZLjava/lang/String;ZLjava/lang/String;)V", "Landroid/content/Intent;", "intent", Const.INTENT_KEY_APIKEY, "(Landroid/content/Intent;)Landroid/content/Intent;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/sheet/SheetHeightMode;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/sheet/SheetHeightMode;", "I", "c", "Z", "getForceFullOnStacked", "()Z", "Ljava/lang/String;", "getRootToken", "e", Const.INTENT_KEY_UMID, "resolvedVisualStackRoot", "Companion", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.sheet.d0, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SheetLaunchOptions {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean forceFullOnStacked;
    private final SheetHeightMode heightMode;
    private final boolean isRootPanel;
    private final int layer;
    private final String rootToken;
    private final String visualStackRoot;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/sheet/d0$a;", "", "<init>", "()V", "Landroid/content/Intent;", "intent", "Lcom/stepos/ailauncher/sheet/d0;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Intent;)Lcom/stepos/ailauncher/sheet/d0;", "", "c", "(Landroid/content/Intent;)Ljava/lang/String;", "", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Intent;)Z", Const.INTENT_KEY_UMID, "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sheet.d0$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final SheetLaunchOptions a(Intent intent) {
            if (intent != null) {
                return new SheetLaunchOptions(SheetHeightMode.INSTANCE.a(intent.getIntExtra("com.stepos.ailauncher.sheet.extra.HEIGHT_MODE", 0)), C5685n.f(intent.getIntExtra("com.stepos.ailauncher.sheet.extra.LAYER", 1), 1), false, intent.getStringExtra("com.stepos.ailauncher.sheet.extra.ROOT_TOKEN"), intent.getBooleanExtra("com.stepos.ailauncher.sheet.extra.IS_ROOT_PANEL", false), intent.getStringExtra("com.stepos.ailauncher.sheet.extra.VISUAL_STACK_ROOT"), 4, null);
            }
            return new SheetLaunchOptions(null, 0, false, null, false, null, 63, null);
        }

        public final boolean b(Intent intent) {
            return intent != null && intent.getBooleanExtra("com.stepos.ailauncher.sheet.extra.IS_ROOT_PANEL", false);
        }

        public final String c(Intent intent) {
            String stringExtra;
            if (intent == null || (stringExtra = intent.getStringExtra("com.stepos.ailauncher.sheet.extra.ROOT_TOKEN")) == null) {
                return "desktop";
            }
            if (La.H.x0(stringExtra)) {
                stringExtra = null;
            }
            return stringExtra != null ? stringExtra : "desktop";
        }

        public final String d(Intent intent) {
            return a(intent).d();
        }

        public Companion() {
        }
    }

    public SheetLaunchOptions() {
        this(null, 0, false, null, false, null, 63, null);
    }

    public final Intent a(Intent intent) {
        kotlin.jvm.internal.p.i(intent, "intent");
        intent.putExtra("com.stepos.ailauncher.sheet.extra.LAYER", C5685n.f(this.layer, 1)).putExtra("com.stepos.ailauncher.sheet.extra.HEIGHT_MODE", this.heightMode.getWireValue());
        String str = this.rootToken;
        String str2 = null;
        if (str == null || La.H.x0(str)) {
            str = null;
        }
        if (str != null) {
            intent.putExtra("com.stepos.ailauncher.sheet.extra.ROOT_TOKEN", str);
        }
        if (this.isRootPanel) {
            intent.putExtra("com.stepos.ailauncher.sheet.extra.IS_ROOT_PANEL", true);
        }
        String str3 = this.visualStackRoot;
        if (str3 != null && !La.H.x0(str3)) {
            str2 = str3;
        }
        if (str2 != null) {
            kotlin.jvm.internal.p.f(intent.putExtra("com.stepos.ailauncher.sheet.extra.VISUAL_STACK_ROOT", str2));
            return intent;
        }
        intent.removeExtra("com.stepos.ailauncher.sheet.extra.VISUAL_STACK_ROOT");
        return intent;
    }

    /* renamed from: b, reason: from getter */
    public final SheetHeightMode getHeightMode() {
        return this.heightMode;
    }

    /* renamed from: c, reason: from getter */
    public final int getLayer() {
        return this.layer;
    }

    public final String d() {
        String str = this.visualStackRoot;
        String str2 = null;
        if (str != null) {
            if (La.H.x0(str)) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        String str3 = this.rootToken;
        if (str3 != null && !La.H.x0(str3)) {
            str2 = str3;
        }
        return str2 == null ? "desktop" : str2;
    }

    /* renamed from: e, reason: from getter */
    public final String getVisualStackRoot() {
        return this.visualStackRoot;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SheetLaunchOptions)) {
            return false;
        }
        SheetLaunchOptions sheetLaunchOptions = (SheetLaunchOptions) other;
        return this.heightMode == sheetLaunchOptions.heightMode && this.layer == sheetLaunchOptions.layer && this.forceFullOnStacked == sheetLaunchOptions.forceFullOnStacked && kotlin.jvm.internal.p.d(this.rootToken, sheetLaunchOptions.rootToken) && this.isRootPanel == sheetLaunchOptions.isRootPanel && kotlin.jvm.internal.p.d(this.visualStackRoot, sheetLaunchOptions.visualStackRoot);
    }

    public int hashCode() {
        int iHashCode = ((((this.heightMode.hashCode() * 31) + Integer.hashCode(this.layer)) * 31) + Boolean.hashCode(this.forceFullOnStacked)) * 31;
        String str = this.rootToken;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isRootPanel)) * 31;
        String str2 = this.visualStackRoot;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SheetLaunchOptions(heightMode=" + this.heightMode + ", layer=" + this.layer + ", forceFullOnStacked=" + this.forceFullOnStacked + ", rootToken=" + this.rootToken + ", isRootPanel=" + this.isRootPanel + ", visualStackRoot=" + this.visualStackRoot + ")";
    }

    public SheetLaunchOptions(SheetHeightMode heightMode, int i10, boolean z10, String str, boolean z11, String str2) {
        kotlin.jvm.internal.p.i(heightMode, "heightMode");
        this.heightMode = heightMode;
        this.layer = i10;
        this.forceFullOnStacked = z10;
        this.rootToken = str;
        this.isRootPanel = z11;
        this.visualStackRoot = str2;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ SheetLaunchOptions(com.stepos.ailauncher.sheet.SheetHeightMode r2, int r3, boolean r4, java.lang.String r5, boolean r6, java.lang.String r7, int r8, kotlin.jvm.internal.i r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L6
            com.stepos.ailauncher.sheet.SheetHeightMode r2 = com.stepos.ailauncher.sheet.SheetHeightMode.FULL_9
        L6:
            r9 = r8 & 2
            r0 = 1
            if (r9 == 0) goto Lc
            r3 = r0
        Lc:
            r9 = r8 & 4
            if (r9 == 0) goto L11
            r4 = r0
        L11:
            r9 = r8 & 8
            r0 = 0
            if (r9 == 0) goto L17
            r5 = r0
        L17:
            r9 = r8 & 16
            if (r9 == 0) goto L1c
            r6 = 0
        L1c:
            r8 = r8 & 32
            if (r8 == 0) goto L28
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L2f
        L28:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L2f:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sheet.SheetLaunchOptions.<init>(com.stepos.ailauncher.sheet.SheetHeightMode, int, boolean, java.lang.String, boolean, java.lang.String, int, kotlin.jvm.internal.i):void");
    }
}
