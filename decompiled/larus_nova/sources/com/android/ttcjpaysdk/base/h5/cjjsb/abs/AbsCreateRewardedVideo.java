package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\t\n\u000bB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsCreateRewardedVideo;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsCreateRewardedVideo$OpenAdRewardInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsCreateRewardedVideo$OpenAdRewardOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "MoreRewardInfos", "OpenAdRewardInput", "OpenAdRewardOutput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsCreateRewardedVideo extends AbsJSBMethod<OpenAdRewardInput, OpenAdRewardOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsCreateRewardedVideo$MoreRewardInfos;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "closeButtonModal", "Lorg/json/JSONObject;", "oneMoreModal", "retentionModal", "(Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MoreRewardInfos implements IJSBParams {
        public JSONObject closeButtonModal;
        public JSONObject oneMoreModal;
        public JSONObject retentionModal;

        public MoreRewardInfos() {
            this(null, null, null, 7, null);
        }

        public MoreRewardInfos(JSONObject r100, JSONObject r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r100, "closeButtonModal");
            Intrinsics.checkNotNullParameter(r101, "oneMoreModal");
            Intrinsics.checkNotNullParameter(r102, "retentionModal");
            this.closeButtonModal = r100;
            this.oneMoreModal = r101;
            this.retentionModal = r102;
        }

        public /* synthetic */ MoreRewardInfos(JSONObject r100, JSONObject r101, JSONObject r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = new JSONObject();
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = new JSONObject();
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = new JSONObject();
        L11:
            this(r100, r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t¢\u0006\u0002\u0010\u0015R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsCreateRewardedVideo$OpenAdRewardInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", BdpAppEventConstant.PARAMS_RIT, "", "rewardTimes", "adFrom", "", "creatorId", ControlRule.KEY_EXTRA_DATA, "Lorg/json/JSONObject;", "rewardInfo", "extraVideoData", "retentionModel", "moreRewardInfos", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsCreateRewardedVideo$MoreRewardInfos;", "Lkotlin/collections/ArrayList;", "isBizReward", "", "extraParamStr", "bizLogCommonParams", "(IILjava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/util/ArrayList;ZLjava/lang/String;Lorg/json/JSONObject;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OpenAdRewardInput implements IJSBParams {
        public String adFrom;
        public JSONObject bizLogCommonParams;
        public String creatorId;
        public JSONObject extraData;
        public String extraParamStr;
        public JSONObject extraVideoData;
        public boolean isBizReward;
        public ArrayList<MoreRewardInfos> moreRewardInfos;
        public JSONObject retentionModel;
        public JSONObject rewardInfo;
        public int rewardTimes;
        public int rit;

        public OpenAdRewardInput() {
            this(0, 0, null, null, null, null, null, null, null, false, null, null, UnixStat.PERM_MASK, null);
        }

        public OpenAdRewardInput(int r100, int r101, String r102, String r103, JSONObject r104, JSONObject r105, JSONObject r106, JSONObject r107, ArrayList<MoreRewardInfos> r110, boolean r111, String r112, JSONObject r113) {
            Intrinsics.checkNotNullParameter(r102, "adFrom");
            Intrinsics.checkNotNullParameter(r103, "creatorId");
            Intrinsics.checkNotNullParameter(r104, ControlRule.KEY_EXTRA_DATA);
            Intrinsics.checkNotNullParameter(r105, "rewardInfo");
            Intrinsics.checkNotNullParameter(r106, "extraVideoData");
            Intrinsics.checkNotNullParameter(r107, "retentionModel");
            Intrinsics.checkNotNullParameter(r110, "moreRewardInfos");
            Intrinsics.checkNotNullParameter(r112, "extraParamStr");
            Intrinsics.checkNotNullParameter(r113, "bizLogCommonParams");
            this.rit = r100;
            this.rewardTimes = r101;
            this.adFrom = r102;
            this.creatorId = r103;
            this.extraData = r104;
            this.rewardInfo = r105;
            this.extraVideoData = r106;
            this.retentionModel = r107;
            this.moreRewardInfos = r110;
            this.isBizReward = r111;
            this.extraParamStr = r112;
            this.bizLogCommonParams = r113;
        }

        public /* synthetic */ OpenAdRewardInput(int r110, int r111, String r112, String r113, JSONObject r114, JSONObject r115, JSONObject r210, JSONObject r211, ArrayList r212, boolean r213, String r214, JSONObject r215, int r216, DefaultConstructorMarker r217) {
            boolean r100 = false;
            if ((r216 & 1) == 0) goto L5;
            int r101 = 0;
        L7:
            if ((r216 & 2) == 0) goto L9;
            int r102 = 0;
        L10:
            String r103 = "";
            if ((r216 & 4) == 0) goto L13;
            String r104 = "";
        L15:
            if ((r216 & 8) == 0) goto L17;
            String r105 = "";
        L19:
            if ((r216 & 16) == 0) goto L21;
            JSONObject r106 = new JSONObject();
        L23:
            if ((r216 & 32) == 0) goto L25;
            JSONObject r107 = new JSONObject();
        L27:
            if ((r216 & 64) == 0) goto L29;
            JSONObject r108 = new JSONObject();
        L31:
            if ((r216 & 128) == 0) goto L33;
            JSONObject r116 = new JSONObject();
        L35:
            if ((r216 & 256) == 0) goto L37;
            ArrayList r117 = new ArrayList();
        L39:
            if ((r216 & 512) != 0) goto L43;
            r100 = r213;
        L43:
            if ((r216 & 1024) != 0) goto L47;
            r103 = r214;
        L47:
            if ((r216 & 2048) == 0) goto L49;
            JSONObject r109 = new JSONObject();
        L50:
            this(r101, r102, r104, r105, r106, r107, r108, r116, r117, r100, r103, r109);
            return;
        L49:
            r109 = r215;
            goto L50
        L37:
            r117 = r212;
            goto L39
        L33:
            r116 = r211;
            goto L35
        L29:
            r108 = r210;
            goto L31
        L25:
            r107 = r115;
            goto L27
        L21:
            r106 = r114;
            goto L23
        L17:
            r105 = r113;
            goto L19
        L13:
            r104 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L10
        L5:
            r101 = r110;
            goto L7
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsCreateRewardedVideo$OpenAdRewardOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "code", "", "msg", "", "data", "Lorg/json/JSONObject;", "(ILjava/lang/String;Lorg/json/JSONObject;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OpenAdRewardOutput extends JSBBaseOutput {
        public int code;
        public JSONObject data;
        public String msg;

        public OpenAdRewardOutput() {
            this(0, null, null, 7, null);
        }

        public OpenAdRewardOutput(int r100, String r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            Intrinsics.checkNotNullParameter(r102, "data");
            this.code = r100;
            this.msg = r101;
            this.data = r102;
        }

        public /* synthetic */ OpenAdRewardOutput(int r100, String r101, JSONObject r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = new JSONObject();
        L11:
            this(r100, r101, r102);
        }
    }

    public AbsCreateRewardedVideo() {
        this.name = "ttcjpay.createRewardedVideo";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
