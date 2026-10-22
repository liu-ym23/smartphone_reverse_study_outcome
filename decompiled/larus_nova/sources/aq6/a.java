package aq6;

import com.bytedance.locallife.dito.data.DitoActionModel;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f15902a = 0;

    static {
    }

    public static String a(BaseDitoModel r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        DitoNode r101 = r100.f258493b.f258221a;
        if (r101 == null) goto L8;
        List<DitoActionModel> r102 = r101.getActions("refresh");
    L9:
        if (r102 != null) goto L11;
        r102 = new ArrayList();
    L11:
        Iterator<DitoActionModel> r103 = r102.iterator();
    L13:
        if (r103.hasNext() == false) goto L42;
        DitoActionModel r104 = r103.next();
        if (Intrinsics.areEqual(r104.getType(), "request") == false) goto L13;
        if (r104.getDitoParams() != null) goto L26;
        Map<String, Object> r105 = r104.getParams();
        if (r105 == null) goto L21;
        Object r106 = r105.get("dito_params");
    L23:
        if (TypeIntrinsics.isMutableMap(r106) == false) goto L25;
        Map<String, Object> r107 = (Map) r106;
    L27:
        if (r107 == null) goto L29;
        Object r108 = r107.get("node_update_map");
    L31:
        if (TypeIntrinsics.isMutableList(r108) == false) goto L33;
        List r109 = (List) r108;
    L34:
        if (r109 == null) goto L13;
        Iterator r110 = r109.iterator();
    L37:
        if (r110.hasNext() == false) goto L13;
        Map r111 = (Map) r110.next();
        if (Intrinsics.areEqual(r111.get("type"), "refresh") == false) goto L37;
        return (String) r111.get("node");
    L33:
        r109 = null;
        goto L34
    L29:
        r108 = null;
        goto L31
    L25:
        r107 = null;
        goto L27
    L21:
        r106 = null;
        goto L23
    L26:
        r107 = r104.getDitoParams();
        goto L27
    L42:
        return null;
    L8:
        r102 = null;
        goto L9
    }

    public static String b(BaseDitoModel r100) {
        if (r100 == null) goto L7;
        DitoNode r101 = r100.f258493b.f258221a;
        if (r101 == null) goto L7;
        List<DitoActionModel> r102 = r101.getActions("refresh");
    L8:
        if (r102 == null) goto L47;
        Iterator<T> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L15;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((DitoActionModel) r104).getType(), "request") == false) goto L11;
    L16:
        DitoActionModel r105 = (DitoActionModel) r104;
        if (r105 != null) goto L19;
        return null;
    L19:
        if (r105.getDitoParams() != null) goto L35;
        Map<String, Object> r106 = r105.getParams();
        if (r106 == null) goto L23;
        Object r107 = r106.get("dito_params");
    L25:
        if (TypeIntrinsics.isMutableMap(r107) == false) goto L27;
        Map r108 = (Map) r107;
    L28:
        if (r108 == null) goto L30;
        Object r109 = r108.get("status_view_tag");
    L32:
        if ((r109 instanceof String) == true) goto L34;
        return null;
    L34:
        return (String) r109;
    L30:
        r109 = null;
        goto L32
    L27:
        r108 = null;
        goto L28
    L23:
        r107 = null;
        goto L25
    L35:
        Map<String, Object> r110 = r105.getDitoParams();
        if (r110 == null) goto L38;
        Object r111 = r110.get("status_view_tag");
    L40:
        if ((r111 instanceof String) == true) goto L42;
        return null;
    L42:
        return (String) r111;
    L38:
        r111 = null;
        goto L40
    L15:
        r104 = null;
        goto L16
    L47:
        return null;
    L7:
        r102 = null;
        goto L8
    }
}
