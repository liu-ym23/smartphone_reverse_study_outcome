package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/LandscapeTopMoreHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "e", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeTopMoreHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f115655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f115656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f115657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f115658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f115659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.utils.z1 f115660f;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.f115659e;
    }

    public LandscapeTopMoreHolder(View r100, Context r101, com.bytedance.android.livesdk.utils.z1 r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "disposer");
        super(r100);
        this.f115659e = r101;
        this.f115660f = r102;
        this.f115655a = (TextView) r100.findViewById(R.id.name);
        this.f115656b = (ImageView) r100.findViewById(R.id.red_dot);
        this.f115657c = r100.findViewById(R.id.icon);
        this.f115658d = (TextView) r100.findViewById(R.id.icon_description);
    }
}
