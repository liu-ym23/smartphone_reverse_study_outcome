package bx2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ml.process.bl.MLConfigModel;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, List<a>> f21285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f21286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a> f21287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ax2.c f21288d;

    public e() {
        this.f21285a = new HashMap();
        this.f21286b = new ArrayList();
        this.f21287c = new ArrayList();
    }

    @Override // bx2.d
    public final List<a> a() {
        return this.f21286b;
    }

    @Override // bx2.d
    public final List<a> b() {
        return this.f21287c;
    }

    public final void d(List<a> r100) {
        Iterator<a> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        a r102 = r101.next();
        List<a> r103 = this.f21285a.get(r102.getType());
        if (r103 != null) goto L8;
        r103 = new ArrayList();
        this.f21285a.put(r102.getType(), r103);
    L8:
        r103.add(r102);
        goto L4
    L9:
        r100.clear();
    }

    public final a e(HashMap<String, Object> r100) {
        Object r101 = r100.get("tp");
        ax2.c r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.toString();
    L6:
        if (r103 != null) goto L8;
        a r104 = null;
    L82:
        if (r104 == null) goto L88;
        ax2.c r105 = this.f21288d;
        if (r105 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("drawDataManager");
    L87:
        r104.g(r100, r102);
        goto L88
    L86:
        r102 = r105;
    L88:
        return r104;
    L8:
        if (this.f21285a.containsKey(r103) == false) goto L14;
        List<a> r106 = this.f21285a.get(r103);
        if (r106 == null) goto L14;
        if ((!r106.isEmpty()) == false) goto L14;
        Object r107 = ListProtector.remove(r106, 0);
    L15:
        r104 = (a) r107;
        if (r104 != null) goto L82;
        switch(r103.hashCode()) {
            case 3181: goto L77;
            case 3183: goto L73;
            case 3276: goto L69;
            case 3278: goto L65;
            case 3355: goto L61;
            case 3364: goto L57;
            case 3587: goto L53;
            case 3645: goto L49;
            case 3664: goto L45;
            case 3679: goto L41;
            case 3681: goto L37;
            case 3698: goto L33;
            case 3711: goto L29;
            case 110754: goto L25;
            case 114208: goto L21;
            default: goto L89;
        };
    L89:
        r104 = null;
        goto L82
    L21:
        if (r103.equals("sta") == false) goto L90;
        a r108 = new n();
    L80:
        r104 = r108;
        goto L82
    L90:
        r104 = null;
        goto L82
    L25:
        if (r103.equals("pas") == false) goto L91;
        r108 = new k();
        goto L80
    L91:
        r104 = null;
        goto L82
    L29:
        if (r103.equals("ts") == false) goto L92;
        r108 = new r();
        goto L80
    L92:
        r104 = null;
        goto L82
    L33:
        if (r103.equals(MLConfigModel.MODEL_TYPE_TF) == false) goto L93;
        r108 = new q();
        goto L80
    L93:
        r104 = null;
        goto L82
    L37:
        if (r103.equals(Segment.JsonKey.START) == false) goto L94;
        r108 = new p();
        goto L80
    L94:
        r104 = null;
        goto L82
    L41:
        if (r103.equals(IVideoEventLogger.FEATURE_KEY_SR) == false) goto L95;
        r108 = new o();
        goto L80
    L95:
        r104 = null;
        goto L82
    L45:
        if (r103.equals(SRStrategy.KEY_SR_STRATEGY_CONFIG) == false) goto L96;
        r108 = new m();
        goto L80
    L96:
        r104 = null;
        goto L82
    L49:
        if (r103.equals("ro") == false) goto L97;
        r108 = new l();
        goto L80
    L97:
        r104 = null;
        goto L82
    L53:
        if (r103.equals("ps") == false) goto L98;
        r108 = new j();
        goto L80
    L98:
        r104 = null;
        goto L82
    L57:
        if (r103.equals("im") == false) goto L99;
        r108 = new h();
        goto L80
    L99:
        r104 = null;
        goto L82
    L61:
        if (r103.equals("id") == false) goto L100;
        r108 = new i();
        goto L80
    L100:
        r104 = null;
        goto L82
    L65:
        if (r103.equals("ft") == false) goto L101;
        r108 = new g();
        goto L80
    L101:
        r104 = null;
        goto L82
    L69:
        if (r103.equals("fr") == false) goto L102;
        r108 = new f();
        goto L80
    L102:
        r104 = null;
        goto L82
    L73:
        if (r103.equals(SRStrategy.KEY_CURRENT_RESOLUTION) == false) goto L103;
        r108 = new b();
        goto L80
    L103:
        r104 = null;
        goto L82
    L77:
        if (r103.equals("cp") == false) goto L104;
        r108 = new c();
        goto L80
    L104:
        r104 = null;
    L14:
        r107 = null;
        goto L15
    L5:
        r103 = null;
        goto L6
    }

    public final void c(List<? extends HashMap<String, Object>> r100, boolean r101) {
        if (r100.isEmpty() == false) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        if (r101 == true) goto L18;
        d(this.f21286b);
        ax2.c r103 = this.f21288d;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("drawDataManager");
        r103 = null;
    L12:
        ((ArrayList) r103.f16626j).clear();
        Iterator<? extends HashMap<String, Object>> r104 = r100.iterator();
    L14:
        if (r104.hasNext() == false) goto L24;
        a r105 = e(r104.next());
        if (r105 == null) goto L14;
        ((ArrayList) this.f21286b).add(r105);
        goto L14
    L24:
        return;
    L18:
        d(this.f21287c);
        Iterator<? extends HashMap<String, Object>> r106 = r100.iterator();
    L20:
        if (r106.hasNext() == false) goto L35;
        a r107 = e(r106.next());
        if (r107 == null) goto L20;
        ((ArrayList) this.f21287c).add(r107);
        goto L20
    L35:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
