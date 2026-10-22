package com.bytedance.android.livesdk.chatroom.roommanage.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/roommanage/common/LiveRoomManageEmptyView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/chatroom/roommanage/common/LiveRoomManageEmptyView$a;", "emptyConfig", "", "setEmptyConfig", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomManageEmptyView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f111340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f111341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f111342c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f111343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f111344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CharSequence f111345c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (this.f111343a == r101.f111343a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f111344b, r101.f111344b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f111345c, r101.f111345c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            int r100 = this.f111343a * 31;
            CharSequence r101 = this.f111344b;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            CharSequence r105 = this.f111345c;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            return r104 + r102;
        L5:
            r103 = 0;
            goto L6
        }

        public final String toString() {
            return "EmptyConfig(emptyImageResId=" + this.f111343a + ", emptyTitle=" + this.f111344b + ", emptyTips=" + this.f111345c + ")";
        }

        public a(CharSequence r100, CharSequence r101) {
            Intrinsics.checkNotNullParameter(r100, "emptyTitle");
            Intrinsics.checkNotNullParameter(r101, "emptyTips");
            this.f111343a = R.drawable.ttlive_empty_content_dark;
            this.f111344b = r100;
            this.f111345c = r101;
        }
    }

    public LiveRoomManageEmptyView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveRoomManageEmptyView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setEmptyConfig(a r100) {
        Intrinsics.checkNotNullParameter(r100, "emptyConfig");
        this.f111340a.setBackgroundResource(r100.f111343a);
        this.f111341b.setText(r100.f111344b);
        this.f111342c.setText(r100.f111345c);
    }

    public LiveRoomManageEmptyView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_layout_live_room_manage_empty_view, this, true);
        this.f111340a = (ImageView) findViewById(R.id.place_holder_img);
        this.f111341b = (TextView) findViewById(R.id.empty_title);
        this.f111342c = (TextView) findViewById(R.id.empty_tips);
    }

    public /* synthetic */ LiveRoomManageEmptyView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
