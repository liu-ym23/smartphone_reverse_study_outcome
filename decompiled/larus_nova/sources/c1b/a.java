package c1b;

import android.app.Application;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleonv2.lkapi.domain.IDomain$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.manifest.IManifest$Ipc$EventType;
import com.ss.android.lark.chameleonv2.lkapi.manifest.IManifest$Ipc$ManifestUpdateDetail;
import com.ss.android.lark.chameleonv2.lkapi.manifest.IManifest$Ipc$ModuleType;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jcb.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends z0b.a implements icb.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f22109c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IChameleonHandlerContext f22110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22111b;

    /* JADX INFO: renamed from: c1b.a$a, reason: collision with other inner class name */
    public static final class C0390a {
        public static IDomain$Internal$Property a() {
            HashMap r100 = new HashMap();
            HashMap r101 = new HashMap();
            Application r102 = LarkContext.getApplication();
            if (r102 == null) goto L19;
            q1b.a r103 = (q1b.a) k.a(r102, q1b.a.class);
            if (r103 == null) goto L19;
            m r104 = r103.r9();
            if (r104 == null) goto L19;
            User r105 = r104.getUser();
            if (r105 == null) goto L19;
            String r106 = r105.userId;
            if (r106 == null) goto L19;
            Map<String, List<String>> r107 = b.c().o0(r106);
            Intrinsics.checkNotNull(r107);
            Iterator<Map.Entry<String, List<String>>> r108 = r107.entrySet().iterator();
        L14:
            if (r108.hasNext() == false) goto L17;
            Map.Entry<String, List<String>> r109 = r108.next();
            r101.put(r109.getKey(), new ArrayList(r109.getValue()));
            goto L14
        L17:
            return new IDomain$Internal$Property(r100, r101);
        L19:
            return new IDomain$Internal$Property(r100, r101);
        }
    }

    static {
    }

    public a() {
        this.f22111b = "";
    }

    @Override // icb.a
    public final void a(Map<String, ? extends List<String>> r100) {
        if (r100 == null) goto L7;
        IChameleonHandlerContext r101 = this.f22110a;
        if (r101 == null) goto L8;
        r101.sendEvent(IManifest$Ipc$EventType.MANIFEST_UPDATE.getValue(), new IManifest$Ipc$ManifestUpdateDetail(C0390a.a(), IManifest$Ipc$ModuleType.InternalDomain, true, this.f22111b));
        return;
    L8:
        return;
    }

    @Override // z0b.a
    public final void d(IChameleonHandlerContext r100) {
        this.f22110a = r100;
        Application r101 = LarkContext.getApplication();
        if (r101 == null) goto L11;
        q1b.a r102 = (q1b.a) k.a(r101, q1b.a.class);
        if (r102 == null) goto L11;
        m r103 = r102.r9();
        if (r103 == null) goto L11;
        User r104 = r103.getUser();
        if (r104 == null) goto L11;
        String r105 = r104.userId;
    L12:
        if (r105 == null) goto L15;
        this.f22111b = r105;
        b.c().N0(r105, this);
        return;
    L15:
        return;
    L11:
        r105 = null;
        goto L12
    }

    @Override // z0b.a
    public final void e(IChameleonHandlerContext r100) {
        b.c().M0(this);
        this.f22110a = null;
    }
}
