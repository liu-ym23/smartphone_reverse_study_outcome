package ar8;

import androidx.fragment.app.Fragment;
import com.larus.trace.tracknode.TraceFragment;
import com.obric.trace.ObricActionBarTrackType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes26.dex */
public final class b {
    public static final Long b(Map<String, ? extends Object> r100) {
        if (r100 == null) goto L5;
        Object r101 = r100.get(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID);
    L7:
        if ((r101 instanceof Long) == true) goto L9;
        return null;
    L9:
        return (Long) r101;
    L5:
        r101 = null;
        goto L7
    }

    public static final String c(Map<String, ? extends Object> r100) {
        if (r100 == null) goto L5;
        Object r101 = r100.get("enter_method");
    L7:
        if ((r101 instanceof String) == true) goto L9;
        return null;
    L9:
        return (String) r101;
    L5:
        r101 = null;
        goto L7
    }

    public static final Integer d(Map<String, ? extends Object> r100) {
        if (r100 == null) goto L5;
        Object r101 = r100.get("position");
    L7:
        if ((r101 instanceof Integer) == true) goto L9;
        return null;
    L9:
        return (Integer) r101;
    L5:
        r101 = null;
        goto L7
    }

    public static final String e(Map<String, ? extends Object> r100) {
        if (r100 == null) goto L5;
        Object r101 = r100.get("previous_page");
    L7:
        if ((r101 instanceof String) == true) goto L9;
        return null;
    L9:
        return (String) r101;
    L5:
        r101 = null;
        goto L7
    }

    public static final HashMap<String, Object> a(Map<String, ? extends Object> r100, Fragment r101) {
        HashMap<String, Object> r102 = new HashMap();
        if (r100 == null) goto L8;
        Iterator<Map.Entry<String, ? extends Object>> r103 = r100.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<String, ? extends Object> r104 = r103.next();
        r102.put(r104.getKey(), r104.getValue());
    L8:
        String r105 = null;
        if ((r101 instanceof TraceFragment) == false) goto L11;
        TraceFragment r106 = (TraceFragment) r101;
    L12:
        if (r106 == null) goto L14;
        r105 = r106.k();
    L14:
        r102.put("previous_page", r105);
        return r102;
    L11:
        r106 = null;
        goto L12
    }
}
