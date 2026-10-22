package com.bytedance.android.ec.model.playback;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 -2\u00020\u0001:\u0001.B±\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0018\u0012\u0012\b\u0002\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010&¢\u0006\u0004\b+\u0010,R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u0019\u0010!\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001cR\u0019\u0010#\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010\u001cR\u0019\u0010%\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b%\u0010\u001a\u001a\u0004\b%\u0010\u001cR!\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lcom/bytedance/android/ec/model/playback/ExplainPlaybackRequest;", "Ljava/io/Serializable;", "", "promotionId", "Ljava/lang/String;", "getPromotionId", "()Ljava/lang/String;", "roomId", "getRoomId", "authorId", "getAuthorId", "secAuthorId", "getSecAuthorId", "sourcePage", "getSourcePage", "entranceInfo", "getEntranceInfo", "", "needAdaptAddr", "Z", "getNeedAdaptAddr", "()Z", "carrierSource", "getCarrierSource", "", "modelType", "Ljava/lang/Integer;", "getModelType", "()Ljava/lang/Integer;", "enterScene", "getEnterScene", "originFragmentId", "getOriginFragmentId", "enableMultiCard", "getEnableMultiCard", "pageSize", "getPageSize", "isFirstPage", "", "promotionIDs", "Ljava/util/List;", "getPromotionIDs", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ExplainPlaybackRequest implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private final String authorId;
    private final String carrierSource;
    private final Integer enableMultiCard;
    private final String enterScene;
    private final String entranceInfo;
    private final Integer isFirstPage;
    private final Integer modelType;
    private final boolean needAdaptAddr;
    private final String originFragmentId;
    private final Integer pageSize;
    private final List<String> promotionIDs;
    private final String promotionId;
    private final String roomId;
    private final String secAuthorId;
    private final String sourcePage;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getCarrierSource() {
        return this.carrierSource;
    }

    public final Integer getEnableMultiCard() {
        return this.enableMultiCard;
    }

    public final String getEnterScene() {
        return this.enterScene;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final Integer getModelType() {
        return this.modelType;
    }

    public final boolean getNeedAdaptAddr() {
        return this.needAdaptAddr;
    }

    public final String getOriginFragmentId() {
        return this.originFragmentId;
    }

    public final Integer getPageSize() {
        return this.pageSize;
    }

    public final List<String> getPromotionIDs() {
        return this.promotionIDs;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public final Integer isFirstPage() {
        return this.isFirstPage;
    }

    public ExplainPlaybackRequest(String r100, String r101, String r102, String r110, String r111, String r112, boolean r113, String r114, Integer r115, String r116, String r117, Integer r118, Integer r119, Integer r210, List<String> r211) {
        Intrinsics.checkNotNullParameter(r100, "promotionId");
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(r102, "authorId");
        Intrinsics.checkNotNullParameter(r110, "secAuthorId");
        this.promotionId = r100;
        this.roomId = r101;
        this.authorId = r102;
        this.secAuthorId = r110;
        this.sourcePage = r111;
        this.entranceInfo = r112;
        this.needAdaptAddr = r113;
        this.carrierSource = r114;
        this.modelType = r115;
        this.enterScene = r116;
        this.originFragmentId = r117;
        this.enableMultiCard = r118;
        this.pageSize = r119;
        this.isFirstPage = r210;
        this.promotionIDs = r211;
    }

    public /* synthetic */ ExplainPlaybackRequest(String r210, String r211, String r212, String r213, String r214, String r215, boolean r216, String r217, Integer r218, String r219, String r310, Integer r311, Integer r312, Integer r313, List r314, int r315, DefaultConstructorMarker r316) {
        if ((r315 & 16) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r315 & 32) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r315 & 64) == 0) goto L13;
        boolean r110 = false;
    L15:
        if ((r315 & 128) == 0) goto L17;
        String r111 = null;
    L19:
        if ((r315 & 256) == 0) goto L21;
        Integer r112 = null;
    L23:
        if ((r315 & 512) == 0) goto L25;
        String r113 = null;
    L27:
        if ((r315 & 1024) == 0) goto L29;
        String r114 = null;
    L31:
        if ((r315 & 2048) == 0) goto L33;
        Integer r115 = 0;
    L35:
        if ((r315 & 4096) == 0) goto L37;
        Integer r116 = 10;
    L39:
        if ((r315 & 8192) == 0) goto L41;
        Integer r117 = 1;
    L43:
        if ((r315 & 16384) == 0) goto L45;
        List r118 = null;
    L46:
        this(r210, r211, r212, r213, r100, r101, r110, r111, r112, r113, r114, r115, r116, r117, r118);
        return;
    L45:
        r118 = r314;
        goto L46
    L41:
        r117 = r313;
        goto L43
    L37:
        r116 = r312;
        goto L39
    L33:
        r115 = r311;
        goto L35
    L29:
        r114 = r310;
        goto L31
    L25:
        r113 = r219;
        goto L27
    L21:
        r112 = r218;
        goto L23
    L17:
        r111 = r217;
        goto L19
    L13:
        r110 = r216;
        goto L15
    L9:
        r101 = r215;
        goto L11
    L5:
        r100 = r214;
        goto L7
    }
}
