package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.selected.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.livesdk.chatroom.ui.NoTouchRecyclerView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/selected/view/MultiUserAvatarView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiUserAvatarView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MultiUserAvatarAdapter f144214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<k> f144215b;

    public static final class a {
    }

    static {
    }

    public MultiUserAvatarView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MultiUserAvatarView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a(List<k> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "avatarImageMode");
        this.f144215b = r100;
        MultiUserAvatarAdapter r102 = this.f144214a;
        if (r102 == null) goto L5;
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        r102.f144211b = r100;
    L5:
        MultiUserAvatarAdapter r103 = this.f144214a;
        if (r103 == null) goto L8;
        r103.f144210a = r101;
    L8:
        if (r103 == null) goto L11;
        r103.notifyDataSetChanged();
        return;
    }

    public MultiUserAvatarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        new ArrayList();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_multi_avatar_view, this);
        NoTouchRecyclerView r103 = (NoTouchRecyclerView) findViewById(R.id.avatar_rv);
        if (r103 == null) goto L5;
        LinearLayoutManager r104 = new LinearLayoutManager(r100);
        r104.setOrientation(0);
        Unit r105 = Unit.INSTANCE;
        r103.setLayoutManager(r104);
    L5:
        if (r103 == null) goto L7;
        r103.setChildDrawingOrderCallback(new AnonymousClass2());
    L7:
        if (r103 == null) goto L9;
        r103.addItemDecoration(new AnonymousClass3());
    L9:
        MultiUserAvatarAdapter r106 = new MultiUserAvatarAdapter(r100);
        this.f144214a = r106;
        r106.f144212c = 4;
        if (r103 == null) goto L13;
        r103.setAdapter(r106);
        return;
    }

    public /* synthetic */ MultiUserAvatarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
