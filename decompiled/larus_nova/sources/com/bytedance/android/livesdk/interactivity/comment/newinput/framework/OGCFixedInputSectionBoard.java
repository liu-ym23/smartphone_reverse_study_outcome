package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.livesdk.interactivity.api.input.viewpager.InputSectionBoard;
import com.bytedance.android.livesdk.interactivity.api.input.viewpager.SelectionListAdapter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014R\"\u0010\u000e\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/OGCFixedInputSectionBoard;", "Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/InputSectionBoard;", "", "colorStr", "", "setTitleColor", "", "getLayoutId", "f", "Ljava/lang/String;", "getTitleColorStr", "()Ljava/lang/String;", "setTitleColorStr", "(Ljava/lang/String;)V", "titleColorStr", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OGCFixedInputSectionBoard extends InputSectionBoard {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f135468f;

    public OGCFixedInputSectionBoard(Context r100) {
        this(r100, null, 0, 14);
    }

    public OGCFixedInputSectionBoard(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 12);
    }

    public OGCFixedInputSectionBoard(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 8);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.InputSectionBoard
    public int getLayoutId() {
        return R.layout.ttlive_ogc_fixed_input_board;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.InputSectionBoard
    public final SelectionListAdapter b() {
        return new OGCFixedInputSelectionListAdapter(this.f135468f, getSelectionRecycleView(), getSelections());
    }

    public final String getTitleColorStr() {
        return this.f135468f;
    }

    public void setTitleColor(String r100) {
        if (r100 == null) goto L5;
        this.f135468f = r100;
        return;
    }

    public final void setTitleColorStr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f135468f = r100;
    }

    public OGCFixedInputSectionBoard(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        this.f135468f = "#161823";
    }
}
