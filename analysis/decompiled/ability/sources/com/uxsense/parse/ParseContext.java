package com.uxsense.parse;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.uxsense.user.AccountEntry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b'\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u00100\u001a\u00020\u000fHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0012HÆ\u0003J\u0092\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0012HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\u000f2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0007HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u0015\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001eR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u00069"}, d2 = {"Lcom/uxsense/parse/ParseContext;", "", "appName", "", "account", "Lcom/uxsense/user/AccountEntry;", "androidUserId", "", "userId", "", "creationId", "rootCommentId", "chatId", "senderId", "autoSave", "", "screenshotPath", GuiTaskProgressKt.GuiTaskProgress_KEY_EXTRAS, "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lcom/uxsense/user/AccountEntry;IJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;ZLjava/lang/String;Ljava/util/Map;)V", "getAppName", "()Ljava/lang/String;", "getAccount", "()Lcom/uxsense/user/AccountEntry;", "getAndroidUserId", "()I", "getUserId", "()J", "getCreationId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRootCommentId", "getChatId", "getSenderId", "getAutoSave", "()Z", "getScreenshotPath", "getExtras", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Lcom/uxsense/user/AccountEntry;IJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;ZLjava/lang/String;Ljava/util/Map;)Lcom/uxsense/parse/ParseContext;", "equals", "other", "hashCode", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ParseContext {
    private final AccountEntry account;
    private final int androidUserId;
    private final String appName;
    private final boolean autoSave;
    private final Long chatId;
    private final Long creationId;
    private final Map<String, Object> extras;
    private final Long rootCommentId;
    private final String screenshotPath;
    private final Long senderId;
    private final long userId;

    public ParseContext(String appName, AccountEntry account, int i, long j5, Long l, Long l5, Long l9, Long l10, boolean z10, String str, Map<String, ? extends Object> extras) {
        k.f(appName, "appName");
        k.f(account, "account");
        k.f(extras, "extras");
        this.appName = appName;
        this.account = account;
        this.androidUserId = i;
        this.userId = j5;
        this.creationId = l;
        this.rootCommentId = l5;
        this.chatId = l9;
        this.senderId = l10;
        this.autoSave = z10;
        this.screenshotPath = str;
        this.extras = extras;
    }

    public static /* synthetic */ ParseContext copy$default(ParseContext parseContext, String str, AccountEntry accountEntry, int i, long j5, Long l, Long l5, Long l9, Long l10, boolean z10, String str2, Map map, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = parseContext.appName;
        }
        if ((i6 & 2) != 0) {
            accountEntry = parseContext.account;
        }
        if ((i6 & 4) != 0) {
            i = parseContext.androidUserId;
        }
        if ((i6 & 8) != 0) {
            j5 = parseContext.userId;
        }
        if ((i6 & 16) != 0) {
            l = parseContext.creationId;
        }
        if ((i6 & 32) != 0) {
            l5 = parseContext.rootCommentId;
        }
        if ((i6 & 64) != 0) {
            l9 = parseContext.chatId;
        }
        if ((i6 & 128) != 0) {
            l10 = parseContext.senderId;
        }
        if ((i6 & 256) != 0) {
            z10 = parseContext.autoSave;
        }
        if ((i6 & 512) != 0) {
            str2 = parseContext.screenshotPath;
        }
        if ((i6 & 1024) != 0) {
            map = parseContext.extras;
        }
        String str3 = str2;
        Map map2 = map;
        boolean z11 = z10;
        Long l11 = l9;
        Long l12 = l;
        long j6 = j5;
        int i10 = i;
        return parseContext.copy(str, accountEntry, i10, j6, l12, l5, l11, l10, z11, str3, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component10, reason: from getter */
    public final String getScreenshotPath() {
        return this.screenshotPath;
    }

    public final Map<String, Object> component11() {
        return this.extras;
    }

    /* renamed from: component2, reason: from getter */
    public final AccountEntry getAccount() {
        return this.account;
    }

    /* renamed from: component3, reason: from getter */
    public final int getAndroidUserId() {
        return this.androidUserId;
    }

    /* renamed from: component4, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* renamed from: component5, reason: from getter */
    public final Long getCreationId() {
        return this.creationId;
    }

    /* renamed from: component6, reason: from getter */
    public final Long getRootCommentId() {
        return this.rootCommentId;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getChatId() {
        return this.chatId;
    }

    /* renamed from: component8, reason: from getter */
    public final Long getSenderId() {
        return this.senderId;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getAutoSave() {
        return this.autoSave;
    }

    public final ParseContext copy(String appName, AccountEntry account, int androidUserId, long userId, Long creationId, Long rootCommentId, Long chatId, Long senderId, boolean autoSave, String screenshotPath, Map<String, ? extends Object> extras) {
        k.f(appName, "appName");
        k.f(account, "account");
        k.f(extras, "extras");
        return new ParseContext(appName, account, androidUserId, userId, creationId, rootCommentId, chatId, senderId, autoSave, screenshotPath, extras);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParseContext)) {
            return false;
        }
        ParseContext parseContext = (ParseContext) other;
        return k.b(this.appName, parseContext.appName) && k.b(this.account, parseContext.account) && this.androidUserId == parseContext.androidUserId && this.userId == parseContext.userId && k.b(this.creationId, parseContext.creationId) && k.b(this.rootCommentId, parseContext.rootCommentId) && k.b(this.chatId, parseContext.chatId) && k.b(this.senderId, parseContext.senderId) && this.autoSave == parseContext.autoSave && k.b(this.screenshotPath, parseContext.screenshotPath) && k.b(this.extras, parseContext.extras);
    }

    public final AccountEntry getAccount() {
        return this.account;
    }

    public final int getAndroidUserId() {
        return this.androidUserId;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final boolean getAutoSave() {
        return this.autoSave;
    }

    public final Long getChatId() {
        return this.chatId;
    }

    public final Long getCreationId() {
        return this.creationId;
    }

    public final Map<String, Object> getExtras() {
        return this.extras;
    }

    public final Long getRootCommentId() {
        return this.rootCommentId;
    }

    public final String getScreenshotPath() {
        return this.screenshotPath;
    }

    public final Long getSenderId() {
        return this.senderId;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int iC = androidx.appfunctions.metadata.a.c(androidx.constraintlayout.core.dsl.a.a(this.androidUserId, (this.account.hashCode() + (this.appName.hashCode() * 31)) * 31, 31), 31, this.userId);
        Long l = this.creationId;
        int iHashCode = (iC + (l == null ? 0 : l.hashCode())) * 31;
        Long l5 = this.rootCommentId;
        int iHashCode2 = (iHashCode + (l5 == null ? 0 : l5.hashCode())) * 31;
        Long l9 = this.chatId;
        int iHashCode3 = (iHashCode2 + (l9 == null ? 0 : l9.hashCode())) * 31;
        Long l10 = this.senderId;
        int iD = androidx.appfunctions.metadata.a.d((iHashCode3 + (l10 == null ? 0 : l10.hashCode())) * 31, 31, this.autoSave);
        String str = this.screenshotPath;
        return this.extras.hashCode() + ((iD + (str != null ? str.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "ParseContext(appName=" + this.appName + ", account=" + this.account + ", androidUserId=" + this.androidUserId + ", userId=" + this.userId + ", creationId=" + this.creationId + ", rootCommentId=" + this.rootCommentId + ", chatId=" + this.chatId + ", senderId=" + this.senderId + ", autoSave=" + this.autoSave + ", screenshotPath=" + this.screenshotPath + ", extras=" + this.extras + ')';
    }

    public /* synthetic */ ParseContext(String str, AccountEntry accountEntry, int i, long j5, Long l, Long l5, Long l9, Long l10, boolean z10, String str2, Map map, int i6, e eVar) {
        this(str, accountEntry, i, j5, (i6 & 16) != 0 ? null : l, (i6 & 32) != 0 ? null : l5, (i6 & 64) != 0 ? null : l9, (i6 & 128) != 0 ? null : l10, (i6 & 256) != 0 ? true : z10, (i6 & 512) != 0 ? null : str2, (i6 & 1024) != 0 ? kotlin.collections.a.M() : map);
    }
}
