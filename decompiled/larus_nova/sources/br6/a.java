package br6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R$\u0010 \u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019¨\u0006%"}, d2 = {"Lbr6/a;", "", "Lbr6/d;", "frequency", "Lbr6/d;", "getFrequency", "()Lbr6/d;", "setFrequency", "(Lbr6/d;)V", "", "maxGuideTimes", "I", "getMaxGuideTimes", "()I", "setMaxGuideTimes", "(I)V", "slideVideoCnt", "getSlideVideoCnt", "setSlideVideoCnt", "", "guideText", "Ljava/lang/String;", "getGuideText", "()Ljava/lang/String;", "setGuideText", "(Ljava/lang/String;)V", "fullBtnName", "getFullBtnName", "setFullBtnName", "dualBtnName", "getDualBtnName", "setDualBtnName", "confirmText", "getConfirmText", "setConfirmText", "<init>", "()V", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("confirm_text")
    private String confirmText;

    @SerializedName("dual_btn_name")
    private String dualBtnName;

    @SerializedName("frequency")
    private d frequency;

    @SerializedName("full_btn_name")
    private String fullBtnName;

    @SerializedName("guide_text")
    private String guideText;

    @SerializedName("max_guide_times")
    private int maxGuideTimes;

    @SerializedName("slide_video_cnt")
    private int slideVideoCnt;

    public a() {
        this.frequency = new d(0);
    }
}
