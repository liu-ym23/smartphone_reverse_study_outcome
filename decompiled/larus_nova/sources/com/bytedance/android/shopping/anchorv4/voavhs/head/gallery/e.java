package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f168636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f168637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnClickListener f168638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, String> f168639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Integer, String> f168640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Integer> f168641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<String> f168642g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<TextView> f168643h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f168644i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f168645j;

    public interface a {
        void a(int r100);
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f168646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f168647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f168648c;

        public b(TextView r100, int r101, ViewGroup r102) {
            this.f168646a = r100;
            this.f168647b = r101;
            this.f168648c = r102;
        }

        public final void a() {
            TextView r100 = this.f168646a;
            ViewGroup.LayoutParams r101 = r100.getLayoutParams();
            r101.width = -2;
            r101.height = -2;
            Unit r102 = Unit.INSTANCE;
            r100.setLayoutParams(r101);
            TextView r103 = this.f168646a;
            ViewGroup.LayoutParams r104 = r103.getLayoutParams();
            if ((r104 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
            r104 = null;
        L5:
            ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
            if (r105 != null) goto L8;
            return;
        L8:
            if (this.f168647b != 0) goto L10;
            int r106 = 0;
        L11:
            r105.leftMargin = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r106));
            r103.setLayoutParams(r105);
            return;
        L10:
            r106 = 24;
            goto L11
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f168649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f168650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f168651c;

        public c(e r100, String r101, ViewGroup r102) {
            this.f168649a = r100;
            this.f168650b = r101;
            this.f168651c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Map<String, Integer> r101 = this.f168649a.f168641f;
            HashMap r102 = (HashMap) r101;
            Integer r103 = (Integer) r102.get(this.f168650b);
            if (r103 == null) goto L8;
            int r104 = r103.intValue();
            a r105 = this.f168649a.f168637b;
            if (r105 == null) goto L9;
            r105.a(r104);
            return;
        L9:
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f168652a;

        public d(e r100) {
            this.f168652a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            View.OnClickListener r101 = this.f168652a.f168638c;
            if (r101 == null) goto L6;
            r101.onClick(r100);
            return;
        }
    }

    public e() {
        this.f168639d = new HashMap();
        this.f168640e = new HashMap();
        this.f168641f = new HashMap();
        this.f168642g = CollectionsKt.emptyList();
        this.f168643h = new ArrayList();
    }

    public final void a(ViewGroup r110) {
        Intrinsics.checkNotNullParameter(r110, RootDescription.ROOT_ELEMENT);
        ((ArrayList) this.f168643h).clear();
        View r100 = th.a.c(r110.getContext(), R.layout.ec_commerce_anchor_v4_gallery_layout, r110, true);
        if (r100 == null) goto L58;
        FrameLayout r101 = (FrameLayout) r100;
        this.f168636a = r101;
        Context r102 = r101.getContext();
        ViewGroup r103 = null;
        if (r102 == null) goto L16;
        int r104 = eh.b.b(r102);
        FrameLayout r105 = this.f168636a;
        if (r105 == null) goto L16;
        View r106 = r105.findViewById(R.id.header);
        if (r106 == null) goto L16;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == true) goto L13;
        r107 = null;
    L13:
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        if (r108 == null) goto L16;
        r108.topMargin = r104;
        r106.setLayoutParams(r108);
    L16:
        FrameLayout r109 = this.f168636a;
        if (r109 == null) goto L19;
        View r111 = r109.findViewById(R.id.iv_close);
    L20:
        this.f168645j = r111;
        if (r111 == null) goto L24;
        r111.setOnClickListener(new d(this));
    L24:
        if (this.f168642g.size() > 1) goto L26;
        return;
    L26:
        FrameLayout r112 = this.f168636a;
        if (r112 == null) goto L29;
        r103 = (ViewGroup) r112.findViewById(R.id.tv_indicator);
    L29:
        if (r103 == null) goto L31;
        r103.removeAllViews();
    L31:
        Iterator<T> r113 = this.f168642g.iterator();
        int r114 = 0;
    L33:
        if (r113.hasNext() == false) goto L47;
        String r115 = (String) r113.next();
        TextView r116 = new TextView(r110.getContext());
        int r117 = g.f168664a;
        Intrinsics.checkNotNullParameter(r115, "type");
        String r118 = (String) ((LinkedHashMap) g.f168665b).get(r115);
        if (r118 != null) goto L38;
        r118 = "";
    L38:
        if (r118.length() != 0) goto L40;
        boolean r119 = true;
    L41:
        if (r119 == true) goto L46;
        r116.setBackgroundResource(R.drawable.commerce_bg_gallery_video_image_indicator);
        r116.setPadding(0, com.bytedance.android.shopping.extensions.b.b(8), 0, com.bytedance.android.shopping.extensions.b.b(8));
        r116.setText(r118);
        r116.setTextSize(17.0f);
        r116.setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[0]}, new int[]{-1, r116.getContext().getResources().getColor(R.color.shopping_color_80FFFFFF)}));
        r116.post(new b(r116, r114, r103));
        r116.setOnClickListener(new c(this, r115, r103));
        if (r103 == null) goto L45;
        r103.addView(r116);
    L45:
        ((ArrayList) this.f168643h).add(r116);
    L46:
        r114 = r114 + 1;
        goto L33
    L40:
        r119 = false;
        goto L41
    L47:
        if (r103 == null) goto L49;
        int r120 = r103.getChildCount();
    L50:
        if (r120 > 1) goto L53;
        if (r103 == null) goto L62;
        r103.setVisibility(4);
        return;
    L62:
        return;
    L53:
        this.f168644i = r103;
        if (r103 == null) goto L64;
        r103.setVisibility(0);
        return;
    L64:
        return;
    L49:
        r120 = 0;
        goto L50
    L19:
        r111 = null;
        goto L20
    L58:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public final void b(List<h> r110) {
        Intrinsics.checkNotNullParameter(r110, "galleryMediaModelGroupList");
        ((HashMap) this.f168639d).clear();
        ((HashMap) this.f168641f).clear();
        ((HashMap) this.f168640e).clear();
        Iterator r100 = ((ArrayList) r110).iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L10;
        h r102 = (h) r100.next();
        Iterator<T> r103 = r102.f168667b.iterator();
        int r104 = 0;
    L7:
        if (r103.hasNext() == false) goto L9;
        r103.next();
        Map<Integer, String> r105 = this.f168639d;
        int r106 = r101 + r104;
        HashMap r107 = (HashMap) r105;
        r107.put(Integer.valueOf(r106), r102.getType());
        Map<Integer, String> r108 = this.f168640e;
        HashMap r109 = (HashMap) r108;
        r109.put(Integer.valueOf(r106), r102.f168668c);
        r104 = r104 + 1;
        goto L7
    L9:
        Map<String, Integer> r111 = this.f168641f;
        HashMap r112 = (HashMap) r111;
        r112.put(r102.getType(), Integer.valueOf(r101));
        r101 = r101 + r102.f168667b.size();
        goto L4
    L10:
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator<T> r114 = r110.iterator();
    L12:
        if (r114.hasNext() == false) goto L14;
        r113.add(((h) r114.next()).getType());
        goto L12
    L14:
        this.f168642g = r113;
    }

    public final void c(int r100) {
        Map<Integer, String> r101 = this.f168639d;
        HashMap r102 = (HashMap) r101;
        String r103 = (String) r102.get(Integer.valueOf(r100));
        if (r103 == null) goto L20;
        Iterator<String> r104 = this.f168642g.iterator();
        int r105 = 0;
    L6:
        if (r104.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(r104.next(), r103) == true) goto L12;
        r105 = r105 + 1;
    L12:
        int r106 = ((ArrayList) this.f168643h).size();
        if (r105 < 0) goto L25;
        if (r106 <= r105) goto L24;
        TextView r107 = (TextView) ListProtector.get(this.f168643h, r105);
        Intrinsics.checkNotNullParameter(r107, "indicatorSelected");
        Iterator r108 = ((ArrayList) this.f168643h).iterator();
    L18:
        if (r108.hasNext() == false) goto L26;
        TextView r109 = (TextView) r108.next();
        r109.setSelected(Intrinsics.areEqual(r107, r109));
        goto L18
    L26:
        return;
    L24:
        return;
    L25:
        return;
    L11:
        r105 = -1;
        goto L12
    }
}
