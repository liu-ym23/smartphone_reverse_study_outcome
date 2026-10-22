package by7;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ixigua.lib.track.FrozenTrackNode;
import com.ixigua.lib.track.TrackParams;
import com.larus.nova.R;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes23.dex */
public final class h {
    public static final TrackParams a(e r100) {
        TrackParams r101 = new TrackParams();
        ey7.b.a(r100, r101);
        return r101;
    }

    public static final e b(View r100) {
        Object r101 = r100.getTag(R.id.lib_track_tag_parent_track_node);
        if ((r101 instanceof e) == true) goto L6;
        r101 = null;
    L6:
        return (e) r101;
    }

    public static final FrozenTrackNode c(Intent r100) {
        String r101 = r100.getStringExtra("lib_track_rtn_id");
        ConcurrentHashMap<String, FrozenTrackNode> r102 = ey7.d.f474810a;
        if (r101 == null) goto L5;
        FrozenTrackNode r103 = r102.get(r101);
    L6:
        if (r103 != null) goto L19;
        Uri r104 = r100.getData();
        if (r104 == null) goto L20;
        String r105 = UriProtector.getQueryParameter(r104, "lib_track_rtn_id");     // Catch: Throwable -> L12
    L13:
        ConcurrentHashMap<String, FrozenTrackNode> r106 = ey7.d.f474810a;
        if (r105 != null) goto L16;
        return null;
    L16:
        return r106.get(r105);
    L12:
        r105 = null;
        goto L13
    L20:
        return null;
    L19:
        return r103;
    L5:
        r103 = null;
        goto L6
    }

    public static final FrozenTrackNode d(Fragment r100) {
        Bundle r101 = r100.getArguments();
        if (r101 == null) goto L10;
        String r102 = r101.getString("lib_track_rtn_id", null);
        ConcurrentHashMap<String, FrozenTrackNode> r103 = ey7.d.f474810a;
        if (r102 == null) goto L7;
        FrozenTrackNode r104 = r103.get(r102);
    L8:
        if (r104 == null) goto L10;
        return r104;
    L7:
        r104 = null;
    L10:
        FragmentActivity r105 = r100.getActivity();
        if (r105 == null) goto L17;
        Intent r106 = r105.getIntent();
        if (r106 != null) goto L15;
        return null;
    L15:
        return c(r106);
    L17:
        return null;
    }

    public static final TrackParams e(e r100) {
        e r101 = r100.referrerTrackNode();
        if (r101 == null) goto L7;
        int r102 = ey7.b.f474808a;
        FrozenTrackNode r103 = ey7.d.a(r101);
        if (r103 == null) goto L7;
        return r103.getTrackParams();
    L7:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final e f(Context r100) {
        if ((r100 instanceof e) == false) goto L7;
        return (e) r100;
    L7:
        if ((r100 instanceof ContextWrapper) == false) goto L16;
        ContextWrapper r101 = (ContextWrapper) r100;
        if ((r101.getBaseContext() instanceof e) == false) goto L18;
        Object r102 = r101.getBaseContext();
        if (r102 == null) goto L15;
        return (e) r102;
    L15:
        throw new TypeCastException("null cannot be cast to non-null type com.ixigua.lib.track.ITrackNode");
    L18:
        return null;
    L16:
        return null;
    }

    public static final e g(View r100) {
        if ((r100 instanceof e) == true) goto L5;
        Object r101 = null;
    L6:
        e r102 = (e) r101;
        if (r102 == null) goto L10;
        return r102;
    L10:
        return i.a(r100);
    L5:
        r101 = r100;
        goto L6
    }

    public static final e h(Fragment r100) {
        if ((r100 instanceof e) == true) goto L5;
        Object r101 = null;
    L6:
        e r102 = (e) r101;
        if (r102 == null) goto L10;
        return r102;
    L10:
        return i.b(r100);
    L5:
        r101 = r100;
        goto L6
    }

    public static final void i(Intent r100, e r101) {
        r100.putExtra("lib_track_rtn_id", ey7.d.a(r101).getId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void j(Bundle r100, View r101) {
        String r102 = ey7.d.b(r101);
        TrackParams r103 = new TrackParams();
        int r104 = ey7.b.f474808a;
        View r105 = r101;
    L3:
        Object r106 = null;
        if (r105 == null) goto L26;
        Object r107 = r105.getTag(R.id.lib_track_tag_view_track_model);
        if ((r107 instanceof d) == true) goto L8;
        r107 = null;
    L8:
        d r108 = (d) r107;
        if (r108 == null) goto L12;
        r108.fillTrackParams(r103);
    L12:
        if ((r105 instanceof e) == true) goto L14;
        Object r109 = null;
    L15:
        e r110 = (e) r109;
        if (r110 != null) goto L19;
        r110 = b(r105);
    L19:
        if (r110 != null) goto L20;
        Object r111 = r105.getParent();
        if ((r111 instanceof View) == false) goto L25;
        r106 = r111;
    L25:
        r105 = (View) r106;
        goto L3
    L20:
        ey7.b.a(r110, r103);
    L31:
        e r112 = g(r101);
        if (r112 == null) goto L34;
        e r113 = r112.referrerTrackNode();
    L36:
        if ((r113 instanceof FrozenTrackNode) == true) goto L38;
        r113 = null;
    L38:
        FrozenTrackNode r114 = new FrozenTrackNode(r102, r103, (FrozenTrackNode) r113);
        ey7.d.f474810a.put(r102, r114);
        ConcurrentHashMap<String, j> r115 = ey7.e.f474811a;
        View r116 = r101;
    L39:
        if (r116 == null) goto L57;
        WeakHashMap<Object, String> r117 = ey7.e.f474812b;
        if (r117.containsKey(r116) == true) goto L42;
        if ((r116 instanceof e) == true) goto L46;
        Object r118 = null;
    L47:
        e r119 = (e) r118;
        if (r119 != null) goto L51;
        r119 = b(r116);
    L51:
        if (r119 != null) goto L52;
        Object r120 = r116.getParent();
        if ((r120 instanceof View) == true) goto L56;
        r120 = null;
    L56:
        r116 = (View) r120;
        goto L39
    L52:
        String r121 = ey7.e.a(r119);
    L63:
        if (r121 == 0) goto L65;
        r114.setTrackThreadId(r121);
        ey7.e.f474812b.put(r114, r121);
    L65:
        int r122 = ey7.c.f474809a;
        r100.putString("lib_track_rtn_id", r114.getId());
        return;
    L46:
        r118 = r116;
        goto L47
    L42:
        r121 = r117.get(r116);
        goto L63
    L57:
        Context r123 = r101.getContext();
        if (r123 == null) goto L62;
        e r124 = f(r123);
        if (r124 == null) goto L62;
        r106 = ey7.e.a(r124);
    L62:
        r121 = r106;
        goto L63
    L34:
        r113 = null;
        goto L36
    L14:
        r109 = r105;
        goto L15
    L26:
        Context r125 = r101.getContext();
        if (r125 == null) goto L31;
        e r126 = f(r125);
        if (r126 == null) goto L31;
        ey7.b.a(r126, r103);
        goto L31
    }

    public static final void k(Bundle r100, e r101) {
        r100.putString("lib_track_rtn_id", ey7.d.a(r101).getId());
    }
}
