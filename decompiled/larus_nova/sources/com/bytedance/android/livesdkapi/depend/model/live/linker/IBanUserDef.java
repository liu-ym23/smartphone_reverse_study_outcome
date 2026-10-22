package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IBanUserDef;", "", "anchorExplain", "", "getAnchorExplain$annotations", "()V", "getAnchorExplain", "()Ljava/lang/String;", "audienceExplain", "getAudienceExplain$annotations", "getAudienceExplain", "reason", "getReason$annotations", "getReason", "url", "getUrl$annotations", "getUrl", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBanUserDef {

    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "anchor_explain")
        public static /* synthetic */ void getAnchorExplain$annotations() {
        }

        @FieldName(name = "audience_explain")
        public static /* synthetic */ void getAudienceExplain$annotations() {
        }

        @FieldName(name = "reason")
        public static /* synthetic */ void getReason$annotations() {
        }

        @FieldName(name = "url")
        public static /* synthetic */ void getUrl$annotations() {
        }
    }

    String getAnchorExplain();

    String getAudienceExplain();

    String getReason();

    String getUrl();
}
