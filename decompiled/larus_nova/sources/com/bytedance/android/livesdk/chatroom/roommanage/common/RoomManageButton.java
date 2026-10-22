package com.bytedance.android.livesdk.chatroom.roommanage.common;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.livesdk.utils.x0;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0019\u001a\u001b\nB'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/roommanage/common/RoomManageButton;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/chatroom/roommanage/common/RoomManageButton$b;", "config", "", "setConfig", "Lcom/bytedance/android/livesdk/chatroom/roommanage/common/RoomManageButton$d;", "style", "setStyle", "Lcom/bytedance/android/livesdk/chatroom/roommanage/common/RoomManageButton$c;", "d", "Lcom/bytedance/android/livesdk/chatroom/roommanage/common/RoomManageButton$c;", "getHandleListener", "()Lcom/bytedance/android/livesdk/chatroom/roommanage/common/RoomManageButton$c;", "setHandleListener", "(Lcom/bytedance/android/livesdk/chatroom/roommanage/common/RoomManageButton$c;)V", "handleListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomManageButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f111369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f111370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f111371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f111372d;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f111373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f111374b;

        public b(CharSequence r100, CharSequence r101) {
            Intrinsics.checkNotNullParameter(r100, "handleText");
            Intrinsics.checkNotNullParameter(r101, "reHandleText");
            this.f111373a = r100;
            this.f111374b = r101;
        }
    }

    public interface c {
        void a();

        void b();
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f111375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Drawable f111376b;

        public d(int r100, Drawable r101) {
            this.f111375a = r100;
            this.f111376b = r101;
        }
    }

    static {
    }

    public RoomManageButton(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RoomManageButton(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        int r100 = this.f111371c;
        if (r100 != 0) goto L6;
        this.f111369a.setText(this.f111370b.f111373a);
        setBackgroundResource(R.drawable.ttlive_live_room_manage_handle_bg);
        return;
    L6:
        if (r100 != 1) goto L10;
        this.f111369a.setText(this.f111370b.f111374b);
        setBackgroundResource(R.drawable.ttlive_live_room_manage_re_handle_bg);
        return;
    }

    public final c getHandleListener() {
        return this.f111372d;
    }

    public final void setConfig(b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f111370b = r100;
        a();
    }

    public final void setHandleListener(c r100) {
        this.f111372d = r100;
    }

    public final void setStyle(d r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        int r101 = r100.f111375a;
        if (r101 == 0) goto L5;
        this.f111369a.setTextColor(r101);
    L5:
        Drawable r102 = r100.f111376b;
        if (r102 == null) goto L9;
        setBackground(r102);
        return;
    }

    public RoomManageButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f111370b = new b("", "");
        LayoutInflater.from(r100).inflate(R.layout.ttlive_layout_live_room_manage_button, this, true);
        this.f111369a = (TextView) findViewById(R.id.tv_button);
        setOnClickListener(x0.a(new AnonymousClass1(this)));
    }

    public /* synthetic */ RoomManageButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
