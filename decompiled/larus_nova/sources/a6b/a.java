package a6b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.message.menu.v2.adapter.binder.ContentMessageActionViewHolder;
import com.ss.android.lark.chat.message.menu.v2.i0;
import com.ss.android.lark.chat.message.menu.v2.j0;
import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes35.dex */
public abstract class a implements e<zya.b, ContentMessageActionViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j0 f1978a;

    /* JADX INFO: renamed from: a6b.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0021a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zya.b f1979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f1980b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f1981c;

        public ViewOnClickListenerC0021a(zya.b r100, Ref.BooleanRef r101, a r102) {
            this.f1979a = r100;
            this.f1980b = r101;
            this.f1981c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            zya.d r101 = this.f1979a.f573995j;
            boolean r102 = true;
            if (r101 != null) goto L5;
        L7:
            boolean r103 = false;
        L8:
            if (r103 == false) goto L11;
            Log.i(this.f1981c.e(), "item click is intercepted");
            return;
        L11:
            if (this.f1980b.element == false) goto L28;
            zya.d r104 = this.f1979a.f573995j;
            if (r104 == null) goto L15;
            Intrinsics.checkNotNull(r100);
            r104.b(r100, true);
        L15:
            List<zya.b> r105 = this.f1979a.f573996k;
            List<zya.b> r106 = r105;
            if (r106 != null) goto L18;
        L21:
            if (r102 == true) goto L25;
            j0 r107 = this.f1981c.f1978a;
            if (r107 == null) goto L36;
            r107.c(this.f1979a, r105);
            return;
        L36:
            return;
        L25:
            j0 r108 = this.f1981c.f1978a;
            if (r108 == null) goto L38;
            i0.a(r108, false, null, 7);
            return;
        L38:
            return;
        L18:
            if (r106.isEmpty() == true) goto L21;
            r102 = false;
            goto L21
        L28:
            zya.d r109 = this.f1979a.f573995j;
            if (r109 == null) goto L31;
            Intrinsics.checkNotNull(r100);
            r109.b(r100, false);
        L31:
            j0 r110 = this.f1981c.f1978a;
            if (r110 == null) goto L40;
            i0.a(r110, false, null, 7);
            return;
        L40:
            return;
        L5:
            if (r101.c(this.f1980b.element) != true) goto L7;
            r103 = true;
            goto L8
        }
    }

    public static final class b implements zya.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContentMessageActionViewHolder f1982a;

        @Override // zya.f
        public Context getContext() {
            return this.f1982a.itemView.getContext();
        }

        public b(ContentMessageActionViewHolder r100) {
            this.f1982a = r100;
        }
    }

    public a() {
    }

    public abstract int d();

    public abstract String e();

    @Override // a6b.e
    public final RecyclerView.ViewHolder a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(d(), r100, false);
        Intrinsics.checkNotNull(r101);
        return new ContentMessageActionViewHolder(r101);
    }

    @Override // a6b.e
    public final void b(j0 r100) {
        this.f1978a = r100;
    }

    @Override // a6b.e
    public /* bridge */ /* synthetic */ void c(RecyclerView.ViewHolder r100, zya.e r101) {
        f((ContentMessageActionViewHolder) r100, (zya.b) r101);
    }

    public void f(ContentMessageActionViewHolder r100, zya.b r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, "itemData");
        Ref.BooleanRef r102 = new Ref.BooleanRef();
        r102.element = r101.f573992g;
        zya.d r103 = r101.f573995j;
        boolean r104 = true;
        int r105 = 0;
        if (r103 != null) goto L5;
    L7:
        boolean r106 = false;
    L8:
        if (r106 == false) goto L11;
        r102.element = false;
    L11:
        if (r101.f573994i != null) goto L14;
        r104 = false;
    L14:
        FrameLayout r107 = r100.f415685b;
        if (r104 == false) goto L17;
        int r108 = 0;
    L18:
        r107.setVisibility(r108);
        View r109 = r100.f415684a;
        if ((!r104) == false) goto L21;
        int r110 = 0;
    L22:
        r109.setVisibility(r110);
        if (r104 == false) goto L25;
        r100.f415685b.removeAllViews();
        r100.f415685b.addView(r101.f573994i);
    L42:
        r100.itemView.setOnClickListener(new ViewOnClickListenerC0021a(r101, r102, this));
        zya.d r111 = r101.f573995j;
        if (r111 == null) goto L45;
        r111.d(new b(r100));
    L45:
        zya.d r112 = r101.f573995j;
        if (r112 == null) goto L49;
        r112.onShow();
        return;
    L49:
        return;
    L25:
        Drawable r113 = r101.f573987b;
        r113.mutate();
        boolean r114 = r101.f573988c;
        int r115 = R.color.icon_disable;
        if (r114 == true) goto L28;
        Context r116 = r100.itemView.getContext();
        if (r102.element == false) goto L33;
        r115 = R.color.icon_n1;
    L33:
        r113.setTint(UIUtils.getColor(r116, r115));
    L34:
        r100.f415686c.setImageDrawable(r113);
        r100.f415687d.setText(r101.f573990e);
        View r117 = r100.f415688e;
        if (r101.f573991f == true) goto L38;
        r105 = 8;
    L38:
        r117.setVisibility(r105);
        String r118 = r101.f573998m;
        if (r118 == null) goto L41;
        r100.itemView.setTag(R.id.test_monitor_tag, r118);
    L41:
        r100.f415686c.setEnabled(r102.element);
        r100.f415687d.setEnabled(r102.element);
        r100.f415688e.setEnabled(r102.element);
        goto L42
    L28:
        if (r102.element == true) goto L34;
        r113.setTint(UIUtils.getColor(r100.itemView.getContext(), R.color.icon_disable));
        goto L34
    L21:
        r110 = 8;
        goto L22
    L17:
        r108 = 8;
        goto L18
    L5:
        if (r103.a() != true) goto L7;
        r106 = true;
        goto L8
    }
}
