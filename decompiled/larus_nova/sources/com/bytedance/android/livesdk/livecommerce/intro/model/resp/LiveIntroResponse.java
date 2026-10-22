package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u0007\u001a\u00020\u00002\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003R#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/LiveIntroResponse;", "Ljava/io/Serializable;", "Lcom/bytedance/android/ec/model/g;", "", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/LiveIntro;", "component1", "intros", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "", "clientParams", "Ljava/util/Map;", "getClientParams", "()Ljava/util/Map;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/req/IntroCardScene;", "cardReqScene", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/req/IntroCardScene;", "getCardReqScene", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/req/IntroCardScene;", "setCardReqScene", "(Lcom/bytedance/android/livesdk/livecommerce/intro/model/req/IntroCardScene;)V", "Ljava/util/List;", "getIntros", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveIntroResponse extends com.bytedance.android.ec.model.g implements Serializable {
    private IntroCardScene cardReqScene;
    private final Map<String, String> clientParams;

    @SerializedName("intros")
    private final List<LiveIntro> intros;

    /* JADX WARN: Multi-variable type inference failed */
    public LiveIntroResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveIntroResponse copy$default(LiveIntroResponse r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.intros;
    L6:
        return r100.copy(r101);
    }

    public final List<LiveIntro> component1() {
        return this.intros;
    }

    public final LiveIntroResponse copy(List<LiveIntro> r100) {
        return new LiveIntroResponse(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveIntroResponse) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.intros, ((LiveIntroResponse) r100).intros) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        List<LiveIntro> r100 = this.intros;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "LiveIntroResponse(intros=" + this.intros + ")";
    }

    public final IntroCardScene getCardReqScene() {
        return this.cardReqScene;
    }

    public final Map<String, String> getClientParams() {
        return this.clientParams;
    }

    public final List<LiveIntro> getIntros() {
        return this.intros;
    }

    public LiveIntroResponse(List<LiveIntro> r100) {
        this.intros = r100;
        this.clientParams = new LinkedHashMap();
    }

    public final void setCardReqScene(IntroCardScene r100) {
        this.cardReqScene = r100;
    }

    public /* synthetic */ LiveIntroResponse(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
