package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b&\b\u0080\b\u0018\u00002\u00020\u0001:\u00011BÏ\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b!\u0010\"J\r\u0010$\u001a\u00020#¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020#¢\u0006\u0004\b&\u0010%J\r\u0010'\u001a\u00020#¢\u0006\u0004\b'\u0010%J\u0010\u0010(\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010+\u001a\u00020*HÖ\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010.\u001a\u00020#2\b\u0010-\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b.\u0010/R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u00100\u001a\u0004\b1\u0010)R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00100\u001a\u0004\b2\u0010)R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u00100\u001a\u0004\b3\u0010)R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u00100\u001a\u0004\b4\u0010)R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u00100\u001a\u0004\b5\u0010)R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u00100\u001a\u0004\b6\u0010)R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u00100\u001a\u0004\b7\u0010)R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u00100\u001a\u0004\b8\u0010)R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u00100\u001a\u0004\b9\u0010)R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u00100\u001a\u0004\b:\u0010)R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u00100\u001a\u0004\b;\u0010)R%\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010<\u001a\u0004\b=\u0010>R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u00100\u001a\u0004\b?\u0010)R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u00100\u001a\u0004\b@\u0010)R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u00100\u001a\u0004\bA\u0010)R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u00100\u001a\u0004\bB\u0010)R%\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0015\u0010<\u001a\u0004\bC\u0010>R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u00100\u001a\u0004\bD\u0010)R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u00100\u001a\u0004\bE\u0010)R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u00100\u001a\u0004\bF\u0010)R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\bG\u0010)R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006¢\u0006\f\n\u0004\b\u001c\u0010H\u001a\u0004\bI\u0010JR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001d\u0010H\u001a\u0004\bK\u0010JR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010L\u001a\u0004\bM\u0010NR\u0019\u0010 \u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b \u0010L\u001a\u0004\bO\u0010N¨\u0006P"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;", "LN5/n;", "", "cardId", "mode", "title", Const.JSON_KEY_DESC, "iconUrl", "vendorId", "integrationId", "displayName", "pendingId", "actionType", "startPath", "", "", "startBody", "pollPathTemplate", Const.JSON_KEY_PROVIDER, "completeMethod", "completePath", "completeBody", "statusMethod", "statusPath", "jumpAppLink", "jumpWebLink", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/r;", "fields", "steps", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k$a;", "primaryAction", "secondaryAction", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k$a;Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k$a;)V", "", "z", "()Z", "y", "x", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "l", "v", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "f", "m", Const.INTENT_KEY_PKGNAME, "s", "Ljava/util/Map;", "r", "()Ljava/util/Map;", "n", "p", "getCompleteMethod", Const.INTENT_KEY_UMID, "c", "getStatusMethod", "t", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "k", "Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/List;", "u", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k$a;", "o", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k$a;", "q", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.appauther.k, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class AppAutherCardModel extends N5.n {
    private final String actionType;
    private final String cardId;
    private final Map<String, Object> completeBody;
    private final String completeMethod;
    private final String completePath;
    private final String desc;
    private final String displayName;
    private final List<AppAutherField> fields;
    private final String iconUrl;
    private final String integrationId;
    private final String jumpAppLink;
    private final String jumpWebLink;
    private final String mode;
    private final String pendingId;
    private final String pollPathTemplate;
    private final ActionItem primaryAction;
    private final String provider;
    private final ActionItem secondaryAction;
    private final Map<String, Object> startBody;
    private final String startPath;
    private final String statusMethod;
    private final String statusPath;
    private final List<String> steps;
    private final String title;
    private final String vendorId;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\b\u0080\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0015B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k$a;", "", "", "label", "", "backgroundRes", "textColorRes", "kind", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", "I", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "Companion", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.appauther.k$a, reason: from toString */
    public static final /* data */ class ActionItem {
        public static final String ACTION_COMPLETE_A2A = "complete_a2a";
        public static final String ACTION_JUMP_FOR_KEY = "jump_for_key";
        public static final String ACTION_START_AUTH = "start_auth";
        public static final String ACTION_SUBMIT_KEY = "submit_key";
        private final int backgroundRes;
        private final String kind;
        private final String label;
        private final int textColorRes;

        public ActionItem(String label, int i10, int i11, String kind) {
            kotlin.jvm.internal.p.i(label, "label");
            kotlin.jvm.internal.p.i(kind, "kind");
            this.label = label;
            this.backgroundRes = i10;
            this.textColorRes = i11;
            this.kind = kind;
        }

        /* renamed from: a, reason: from getter */
        public final int getBackgroundRes() {
            return this.backgroundRes;
        }

        /* renamed from: b, reason: from getter */
        public final String getKind() {
            return this.kind;
        }

        /* renamed from: c, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* renamed from: d, reason: from getter */
        public final int getTextColorRes() {
            return this.textColorRes;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActionItem)) {
                return false;
            }
            ActionItem actionItem = (ActionItem) other;
            return kotlin.jvm.internal.p.d(this.label, actionItem.label) && this.backgroundRes == actionItem.backgroundRes && this.textColorRes == actionItem.textColorRes && kotlin.jvm.internal.p.d(this.kind, actionItem.kind);
        }

        public int hashCode() {
            return (((((this.label.hashCode() * 31) + Integer.hashCode(this.backgroundRes)) * 31) + Integer.hashCode(this.textColorRes)) * 31) + this.kind.hashCode();
        }

        public String toString() {
            return "ActionItem(label=" + this.label + ", backgroundRes=" + this.backgroundRes + ", textColorRes=" + this.textColorRes + ", kind=" + this.kind + ")";
        }
    }

    public AppAutherCardModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 33554431, null);
    }

    @Override // N5.n
    /* renamed from: a, reason: from getter */
    public String getCardId() {
        return this.cardId;
    }

    /* renamed from: b, reason: from getter */
    public final String getActionType() {
        return this.actionType;
    }

    public final Map<String, Object> c() {
        return this.completeBody;
    }

    /* renamed from: d, reason: from getter */
    public final String getCompletePath() {
        return this.completePath;
    }

    /* renamed from: e, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppAutherCardModel)) {
            return false;
        }
        AppAutherCardModel appAutherCardModel = (AppAutherCardModel) other;
        return kotlin.jvm.internal.p.d(this.cardId, appAutherCardModel.cardId) && kotlin.jvm.internal.p.d(this.mode, appAutherCardModel.mode) && kotlin.jvm.internal.p.d(this.title, appAutherCardModel.title) && kotlin.jvm.internal.p.d(this.desc, appAutherCardModel.desc) && kotlin.jvm.internal.p.d(this.iconUrl, appAutherCardModel.iconUrl) && kotlin.jvm.internal.p.d(this.vendorId, appAutherCardModel.vendorId) && kotlin.jvm.internal.p.d(this.integrationId, appAutherCardModel.integrationId) && kotlin.jvm.internal.p.d(this.displayName, appAutherCardModel.displayName) && kotlin.jvm.internal.p.d(this.pendingId, appAutherCardModel.pendingId) && kotlin.jvm.internal.p.d(this.actionType, appAutherCardModel.actionType) && kotlin.jvm.internal.p.d(this.startPath, appAutherCardModel.startPath) && kotlin.jvm.internal.p.d(this.startBody, appAutherCardModel.startBody) && kotlin.jvm.internal.p.d(this.pollPathTemplate, appAutherCardModel.pollPathTemplate) && kotlin.jvm.internal.p.d(this.provider, appAutherCardModel.provider) && kotlin.jvm.internal.p.d(this.completeMethod, appAutherCardModel.completeMethod) && kotlin.jvm.internal.p.d(this.completePath, appAutherCardModel.completePath) && kotlin.jvm.internal.p.d(this.completeBody, appAutherCardModel.completeBody) && kotlin.jvm.internal.p.d(this.statusMethod, appAutherCardModel.statusMethod) && kotlin.jvm.internal.p.d(this.statusPath, appAutherCardModel.statusPath) && kotlin.jvm.internal.p.d(this.jumpAppLink, appAutherCardModel.jumpAppLink) && kotlin.jvm.internal.p.d(this.jumpWebLink, appAutherCardModel.jumpWebLink) && kotlin.jvm.internal.p.d(this.fields, appAutherCardModel.fields) && kotlin.jvm.internal.p.d(this.steps, appAutherCardModel.steps) && kotlin.jvm.internal.p.d(this.primaryAction, appAutherCardModel.primaryAction) && kotlin.jvm.internal.p.d(this.secondaryAction, appAutherCardModel.secondaryAction);
    }

    /* renamed from: f, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    public final List<AppAutherField> g() {
        return this.fields;
    }

    /* renamed from: h, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public int hashCode() {
        int iHashCode = ((this.cardId.hashCode() * 31) + this.mode.hashCode()) * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.desc;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.iconUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.vendorId;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.integrationId;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.displayName;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.pendingId;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.actionType;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.startPath;
        int iHashCode10 = (((iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31) + this.startBody.hashCode()) * 31;
        String str10 = this.pollPathTemplate;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.provider;
        int iHashCode12 = (iHashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.completeMethod;
        int iHashCode13 = (iHashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.completePath;
        int iHashCode14 = (((iHashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31) + this.completeBody.hashCode()) * 31;
        String str14 = this.statusMethod;
        int iHashCode15 = (iHashCode14 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.statusPath;
        int iHashCode16 = (iHashCode15 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.jumpAppLink;
        int iHashCode17 = (iHashCode16 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.jumpWebLink;
        int iHashCode18 = (((((iHashCode17 + (str17 == null ? 0 : str17.hashCode())) * 31) + this.fields.hashCode()) * 31) + this.steps.hashCode()) * 31;
        ActionItem actionItem = this.primaryAction;
        int iHashCode19 = (iHashCode18 + (actionItem == null ? 0 : actionItem.hashCode())) * 31;
        ActionItem actionItem2 = this.secondaryAction;
        return iHashCode19 + (actionItem2 != null ? actionItem2.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getIntegrationId() {
        return this.integrationId;
    }

    /* renamed from: j, reason: from getter */
    public final String getJumpAppLink() {
        return this.jumpAppLink;
    }

    /* renamed from: k, reason: from getter */
    public final String getJumpWebLink() {
        return this.jumpWebLink;
    }

    /* renamed from: l, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* renamed from: m, reason: from getter */
    public final String getPendingId() {
        return this.pendingId;
    }

    /* renamed from: n, reason: from getter */
    public final String getPollPathTemplate() {
        return this.pollPathTemplate;
    }

    /* renamed from: o, reason: from getter */
    public final ActionItem getPrimaryAction() {
        return this.primaryAction;
    }

    /* renamed from: p, reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    /* renamed from: q, reason: from getter */
    public final ActionItem getSecondaryAction() {
        return this.secondaryAction;
    }

    public final Map<String, Object> r() {
        return this.startBody;
    }

    /* renamed from: s, reason: from getter */
    public final String getStartPath() {
        return this.startPath;
    }

    /* renamed from: t, reason: from getter */
    public final String getStatusPath() {
        return this.statusPath;
    }

    public String toString() {
        return "AppAutherCardModel(cardId=" + this.cardId + ", mode=" + this.mode + ", title=" + this.title + ", desc=" + this.desc + ", iconUrl=" + this.iconUrl + ", vendorId=" + this.vendorId + ", integrationId=" + this.integrationId + ", displayName=" + this.displayName + ", pendingId=" + this.pendingId + ", actionType=" + this.actionType + ", startPath=" + this.startPath + ", startBody=" + this.startBody + ", pollPathTemplate=" + this.pollPathTemplate + ", provider=" + this.provider + ", completeMethod=" + this.completeMethod + ", completePath=" + this.completePath + ", completeBody=" + this.completeBody + ", statusMethod=" + this.statusMethod + ", statusPath=" + this.statusPath + ", jumpAppLink=" + this.jumpAppLink + ", jumpWebLink=" + this.jumpWebLink + ", fields=" + this.fields + ", steps=" + this.steps + ", primaryAction=" + this.primaryAction + ", secondaryAction=" + this.secondaryAction + ")";
    }

    public final List<String> u() {
        return this.steps;
    }

    /* renamed from: v, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: w, reason: from getter */
    public final String getVendorId() {
        return this.vendorId;
    }

    public final boolean x() {
        return La.D.L(this.actionType, "a2a_consent", true);
    }

    public final boolean y() {
        return !La.D.L(this.actionType, "vendor_callback_flow", true);
    }

    public final boolean z() {
        String str = this.vendorId;
        return !(str == null || La.H.x0(str));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppAutherCardModel(String cardId, String mode, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Map<String, ? extends Object> startBody, String str10, String str11, String str12, String str13, Map<String, ? extends Object> completeBody, String str14, String str15, String str16, String str17, List<AppAutherField> fields, List<String> steps, ActionItem actionItem, ActionItem actionItem2) {
        super(cardId);
        kotlin.jvm.internal.p.i(cardId, "cardId");
        kotlin.jvm.internal.p.i(mode, "mode");
        kotlin.jvm.internal.p.i(startBody, "startBody");
        kotlin.jvm.internal.p.i(completeBody, "completeBody");
        kotlin.jvm.internal.p.i(fields, "fields");
        kotlin.jvm.internal.p.i(steps, "steps");
        this.cardId = cardId;
        this.mode = mode;
        this.title = str;
        this.desc = str2;
        this.iconUrl = str3;
        this.vendorId = str4;
        this.integrationId = str5;
        this.displayName = str6;
        this.pendingId = str7;
        this.actionType = str8;
        this.startPath = str9;
        this.startBody = startBody;
        this.pollPathTemplate = str10;
        this.provider = str11;
        this.completeMethod = str12;
        this.completePath = str13;
        this.completeBody = completeBody;
        this.statusMethod = str14;
        this.statusPath = str15;
        this.jumpAppLink = str16;
        this.jumpWebLink = str17;
        this.fields = fields;
        this.steps = steps;
        this.primaryAction = actionItem;
        this.secondaryAction = actionItem2;
    }

    public /* synthetic */ AppAutherCardModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Map map, String str12, String str13, String str14, String str15, Map map2, String str16, String str17, String str18, String str19, List list, List list2, ActionItem actionItem, ActionItem actionItem2, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "oauth" : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : str7, (i10 & 128) != 0 ? null : str8, (i10 & 256) != 0 ? null : str9, (i10 & 512) != 0 ? null : str10, (i10 & 1024) != 0 ? null : str11, (i10 & 2048) != 0 ? kotlin.collections.a.i() : map, (i10 & 4096) != 0 ? null : str12, (i10 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? null : str13, (i10 & 16384) != 0 ? null : str14, (i10 & 32768) != 0 ? null : str15, (i10 & 65536) != 0 ? kotlin.collections.a.i() : map2, (i10 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? null : str16, (i10 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? null : str17, (i10 & 524288) != 0 ? null : str18, (i10 & 1048576) != 0 ? null : str19, (i10 & 2097152) != 0 ? C1173v.m() : list, (i10 & 4194304) != 0 ? C1173v.m() : list2, (i10 & 8388608) != 0 ? null : actionItem, (i10 & 16777216) != 0 ? null : actionItem2);
    }
}
