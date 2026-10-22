package com.bytedance.android.annie.debug.ui;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class UrlFormDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f39449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f39450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f39451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f39452e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f39453f;

    @Override // android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        View r111 = LayoutInflater.from(getContext()).inflate(R.layout.annie_debug_url_dialog, null, false);
        this.f39450c = r111;
        if (r111 == null) goto L40;
        setContentView(r111);
        Window r112 = getWindow();
        if (r112 == null) goto L7;
        r112.setLayout(-1, -2);
    L7:
        TextView r113 = (TextView) this.f39451d.getValue();
        if (r113 == null) goto L11;
        r113.setText(String.valueOf(this.f39449b.getScheme()));
    L11:
        TextView r114 = (TextView) this.f39452e.getValue();
        if (r114 == null) goto L15;
        r114.setText(this.f39449b.getHost() + this.f39449b.getPath());
    L15:
        Set<String> r115 = UriProtector.getQueryParameterNames(this.f39449b);
        ArrayList r100 = new ArrayList();
        Iterator<T> r116 = r115.iterator();
    L17:
        if (r116.hasNext() == false) goto L25;
        String r101 = (String) r116.next();
        g r102 = new g();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r102.f39472c = r101;
        String r103 = String.valueOf(UriProtector.getQueryParameter(this.f39449b, r101));
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f39473d = r103;
        if (StringsKt.contains$default(r101, "url", false, 2, null) == false) goto L23;
        if (UriProtector.parse(r102.f39473d) == null) goto L23;
        r102.f39470a = 1;
        Uri r104 = UriProtector.parse(r102.f39473d);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r102.f39471b = r104;
    L23:
        r100.add(r102);
        goto L17
    L25:
        if (r100.size() <= 1) goto L27;
        CollectionsKt.sortWith(r100, new h());
    L27:
        UrlFormAdapter r117 = new UrlFormAdapter(r100, this.f39448a);
        RecyclerView r105 = (RecyclerView) this.f39453f.getValue();
        if (r105 == null) goto L31;
        r105.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
    L31:
        RecyclerView r106 = (RecyclerView) this.f39453f.getValue();
        if (r106 == null) goto L41;
        r106.setAdapter(r117);
        return;
    L41:
        return;
    }

    public UrlFormDialog(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "uri");
        super(r100, R.style.annie_debug_dialog);
        this.f39448a = r100;
        this.f39449b = r101;
        this.f39451d = LazyKt.lazy(new UrlFormDialog$annieDebugUrlDialogScheme$2(this));
        this.f39452e = LazyKt.lazy(new UrlFormDialog$annieDebugUrlDialogPath$2(this));
        this.f39453f = LazyKt.lazy(new UrlFormDialog$annieDebugUrlDialogParams$2(this));
    }
}
