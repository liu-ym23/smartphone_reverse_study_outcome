package com.bytedance.android.live.ktv.common.speech;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.component.lyric.ViewPainter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/ktv/common/speech/SpeechLyricsView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/component/lyric/ViewPainter;", "getLyricsView", "Landroid/widget/TextView;", "getAiTipsTextView", "Landroid/widget/ImageView;", "getAiTagView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SpeechLyricsView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPainter f70417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f70418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f70419c;

    public SpeechLyricsView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SpeechLyricsView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final ImageView getAiTagView() {
        return this.f70419c;
    }

    public final TextView getAiTipsTextView() {
        return this.f70418b;
    }

    public final ViewPainter getLyricsView() {
        return this.f70417a;
    }

    public SpeechLyricsView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_multi_lyric_container_layout, this);
        this.f70417a = (ViewPainter) findViewById(R.id.view_painter);
        this.f70418b = (TextView) findViewById(R.id.recognition_ai_tips);
        this.f70419c = (ImageView) findViewById(R.id.recognition_ai_iv);
    }

    public /* synthetic */ SpeechLyricsView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
