package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\u000b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/ui/MultiMicPanelIcon;", "Landroid/widget/LinearLayout;", "", "drawableId", "", "setIcon", "", SocialConstants.PARAM_APP_DESC, "setDesc", "Lkotlin/Function0;", SendEventContainerMethodParamModel.EventKinds.onClick, "setOnClick", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiMicPanelIcon extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f94753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f94754b;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f94755a;

        public a(Function0 r100) {
            this.f94755a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f94755a.invoke();
        }
    }

    public MultiMicPanelIcon(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MultiMicPanelIcon(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setDesc(String r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        TextView r101 = this.f94754b;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setIcon(int r100) {
        ImageView r101 = this.f94753a;
        if (r101 == null) goto L6;
        r101.setImageResource(r100);
        return;
    }

    public final void setOnClick(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
        ImageView r101 = this.f94753a;
        if (r101 == null) goto L6;
        r101.setOnClickListener(new a(r100));
        return;
    }

    public MultiMicPanelIcon(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.ttlive_multi_link_mic_panel_icon, this, true);
        TextView r104 = null;
        if (r103 == null) goto L5;
        ImageView r105 = (ImageView) r103.findViewById(R.id.ttlive_multi_link_icon);
    L6:
        this.f94753a = r105;
        if (r103 == null) goto L9;
        r104 = (TextView) r103.findViewById(R.id.ttlive_multi_link_desc);
    L9:
        this.f94754b = r104;
        return;
    L5:
        r105 = null;
        goto L6
    }

    public /* synthetic */ MultiMicPanelIcon(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
