package com.uxsense.base.parse;

import A9.d;
import B9.L;
import B9.T;
import B9.d0;
import B9.h0;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.core.base.parse.KViewNode;
import com.uxsense.core.base.parse.KViewNode$$serializer;
import com.uxsense.user.AccountEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\b\u0087\b\u0018\u0000 e2\u00020\u0001:\u0002feBÉ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cB£\u0001\b\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001b\u0010 J\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\"J\u0012\u0010&\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b&\u0010\"J\u0012\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b)\u0010\"J\u0010\u0010*\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b*\u0010\"J\u0012\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b-\u0010.J\u0012\u0010/\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b/\u0010\"J\u0012\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b0\u0010(J\u0012\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b1\u0010(J\u0012\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b2\u0010(J\u0012\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b3\u0010(J\u0012\u00104\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b4\u00105J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017HÆ\u0003¢\u0006\u0004\b6\u00107J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017HÆ\u0003¢\u0006\u0004\b8\u00107JÚ\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017HÆ\u0001¢\u0006\u0004\b9\u0010:J\u0010\u0010;\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b;\u0010\"J\u0010\u0010<\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b<\u0010$J\u001a\u0010>\u001a\u00020\u000e2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b>\u0010?J'\u0010H\u001a\u00020E2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010B\u001a\u00020A2\u0006\u0010D\u001a\u00020CH\u0001¢\u0006\u0004\bF\u0010GR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010I\u001a\u0004\bJ\u0010\"R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010K\u001a\u0004\bL\u0010$R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010I\u001a\u0004\bM\u0010\"R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010I\u001a\u0004\bN\u0010\"R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010O\u001a\u0004\bP\u0010(R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010I\u001a\u0004\bQ\u0010\"R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010I\u001a\u0004\bR\u0010\"R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010S\u001a\u0004\bT\u0010,R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010U\u001a\u0004\bV\u0010.R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010I\u001a\u0004\bW\u0010\"R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010O\u001a\u0004\bX\u0010(R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010O\u001a\u0004\bY\u0010(R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010O\u001a\u0004\bZ\u0010(R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0014\u0010O\u001a\u0004\b[\u0010(R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\\\u0012\u0004\b^\u0010_\u001a\u0004\b]\u00105R&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010`\u0012\u0004\bb\u0010_\u001a\u0004\ba\u00107R&\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001a\u0010`\u0012\u0004\bd\u0010_\u001a\u0004\bc\u00107¨\u0006g"}, d2 = {"Lcom/uxsense/base/parse/ParseCache;", "", "", "packageName", "", "androidUserId", "nickname", "uuid", "", "userId", "activity", "windowTitle", "Lcom/uxsense/core/base/parse/KViewNode;", "root", "", "autoSave", "screenshotPath", "creationId", "chatId", "senderId", "rootCommentId", "Lcom/uxsense/user/AccountEntry;", "account", "", "Lcom/uxsense/base/parse/ParseRule;", "rules", "subDirs", AppAgent.CONSTRUCT, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/uxsense/core/base/parse/KViewNode;ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/uxsense/user/AccountEntry;Ljava/util/List;Ljava/util/List;)V", "seen0", "LB9/d0;", "serializationConstructorMarker", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/uxsense/core/base/parse/KViewNode;ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;LB9/d0;)V", "component1", "()Ljava/lang/String;", "component2", "()I", "component3", "component4", "component5", "()Ljava/lang/Long;", "component6", "component7", "component8", "()Lcom/uxsense/core/base/parse/KViewNode;", "component9", "()Z", "component10", "component11", "component12", "component13", "component14", "component15", "()Lcom/uxsense/user/AccountEntry;", "component16", "()Ljava/util/List;", "component17", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/uxsense/core/base/parse/KViewNode;ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/uxsense/user/AccountEntry;Ljava/util/List;Ljava/util/List;)Lcom/uxsense/base/parse/ParseCache;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/base/parse/ParseCache;LA9/d;Lz9/g;)V", "write$Self", "Ljava/lang/String;", "getPackageName", "I", "getAndroidUserId", "getNickname", "getUuid", "Ljava/lang/Long;", "getUserId", "getActivity", "getWindowTitle", "Lcom/uxsense/core/base/parse/KViewNode;", "getRoot", "Z", "getAutoSave", "getScreenshotPath", "getCreationId", "getChatId", "getSenderId", "getRootCommentId", "Lcom/uxsense/user/AccountEntry;", "getAccount", "getAccount$annotations", "()V", "Ljava/util/List;", "getRules", "getRules$annotations", "getSubDirs", "getSubDirs$annotations", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ParseCache {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AccountEntry account;
    private final String activity;
    private final int androidUserId;
    private final boolean autoSave;
    private final Long chatId;
    private final Long creationId;
    private final String nickname;
    private final String packageName;
    private final KViewNode root;
    private final Long rootCommentId;
    private final List<ParseRule> rules;
    private final String screenshotPath;
    private final Long senderId;
    private final List<String> subDirs;
    private final Long userId;
    private final String uuid;
    private final String windowTitle;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/base/parse/ParseCache$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/base/parse/ParseCache;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return ParseCache$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    public ParseCache(int i, String str, int i6, String str2, String str3, Long l, String str4, String str5, KViewNode kViewNode, boolean z10, String str6, Long l5, Long l9, Long l10, Long l11, d0 d0Var) {
        if (99 != (i & 99)) {
            T.g(ParseCache$$serializer.INSTANCE.getDescriptor(), i, 99);
            throw null;
        }
        this.packageName = str;
        this.androidUserId = i6;
        if ((i & 4) == 0) {
            this.nickname = null;
        } else {
            this.nickname = str2;
        }
        if ((i & 8) == 0) {
            this.uuid = null;
        } else {
            this.uuid = str3;
        }
        if ((i & 16) == 0) {
            this.userId = null;
        } else {
            this.userId = l;
        }
        this.activity = str4;
        this.windowTitle = str5;
        if ((i & 128) == 0) {
            this.root = null;
        } else {
            this.root = kViewNode;
        }
        if ((i & 256) == 0) {
            this.autoSave = true;
        } else {
            this.autoSave = z10;
        }
        if ((i & 512) == 0) {
            this.screenshotPath = null;
        } else {
            this.screenshotPath = str6;
        }
        if ((i & 1024) == 0) {
            this.creationId = null;
        } else {
            this.creationId = l5;
        }
        if ((i & 2048) == 0) {
            this.chatId = null;
        } else {
            this.chatId = l9;
        }
        if ((i & 4096) == 0) {
            this.senderId = null;
        } else {
            this.senderId = l10;
        }
        if ((i & 8192) == 0) {
            this.rootCommentId = null;
        } else {
            this.rootCommentId = l11;
        }
        this.account = null;
        EmptyList emptyList = EmptyList.f4893a;
        this.rules = emptyList;
        this.subDirs = emptyList;
    }

    public static /* synthetic */ ParseCache copy$default(ParseCache parseCache, String str, int i, String str2, String str3, Long l, String str4, String str5, KViewNode kViewNode, boolean z10, String str6, Long l5, Long l9, Long l10, Long l11, AccountEntry accountEntry, List list, List list2, int i6, Object obj) {
        List list3;
        List list4;
        String str7;
        ParseCache parseCache2;
        AccountEntry accountEntry2;
        int i10;
        String str8;
        String str9;
        Long l12;
        String str10;
        String str11;
        KViewNode kViewNode2;
        boolean z11;
        String str12;
        Long l13;
        Long l14;
        Long l15;
        Long l16;
        String str13 = (i6 & 1) != 0 ? parseCache.packageName : str;
        int i11 = (i6 & 2) != 0 ? parseCache.androidUserId : i;
        String str14 = (i6 & 4) != 0 ? parseCache.nickname : str2;
        String str15 = (i6 & 8) != 0 ? parseCache.uuid : str3;
        Long l17 = (i6 & 16) != 0 ? parseCache.userId : l;
        String str16 = (i6 & 32) != 0 ? parseCache.activity : str4;
        String str17 = (i6 & 64) != 0 ? parseCache.windowTitle : str5;
        KViewNode kViewNode3 = (i6 & 128) != 0 ? parseCache.root : kViewNode;
        boolean z12 = (i6 & 256) != 0 ? parseCache.autoSave : z10;
        String str18 = (i6 & 512) != 0 ? parseCache.screenshotPath : str6;
        Long l18 = (i6 & 1024) != 0 ? parseCache.creationId : l5;
        Long l19 = (i6 & 2048) != 0 ? parseCache.chatId : l9;
        Long l20 = (i6 & 4096) != 0 ? parseCache.senderId : l10;
        Long l21 = (i6 & 8192) != 0 ? parseCache.rootCommentId : l11;
        String str19 = str13;
        AccountEntry accountEntry3 = (i6 & 16384) != 0 ? parseCache.account : accountEntry;
        List list5 = (i6 & 32768) != 0 ? parseCache.rules : list;
        if ((i6 & 65536) != 0) {
            list4 = list5;
            list3 = parseCache.subDirs;
            accountEntry2 = accountEntry3;
            i10 = i11;
            str8 = str14;
            str9 = str15;
            l12 = l17;
            str10 = str16;
            str11 = str17;
            kViewNode2 = kViewNode3;
            z11 = z12;
            str12 = str18;
            l13 = l18;
            l14 = l19;
            l15 = l20;
            l16 = l21;
            str7 = str19;
            parseCache2 = parseCache;
        } else {
            list3 = list2;
            list4 = list5;
            str7 = str19;
            parseCache2 = parseCache;
            accountEntry2 = accountEntry3;
            i10 = i11;
            str8 = str14;
            str9 = str15;
            l12 = l17;
            str10 = str16;
            str11 = str17;
            kViewNode2 = kViewNode3;
            z11 = z12;
            str12 = str18;
            l13 = l18;
            l14 = l19;
            l15 = l20;
            l16 = l21;
        }
        return parseCache2.copy(str7, i10, str8, str9, l12, str10, str11, kViewNode2, z11, str12, l13, l14, l15, l16, accountEntry2, list4, list3);
    }

    public static /* synthetic */ void getAccount$annotations() {
    }

    public static /* synthetic */ void getRules$annotations() {
    }

    public static /* synthetic */ void getSubDirs$annotations() {
    }

    public static final /* synthetic */ void write$Self$uxsense_release(ParseCache self, d output, g serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.packageName);
        output.encodeIntElement(serialDesc, 1, self.androidUserId);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.nickname != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, h0.f242a, self.nickname);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.uuid != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, h0.f242a, self.uuid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.userId != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, L.f223a, self.userId);
        }
        output.encodeStringElement(serialDesc, 5, self.activity);
        output.encodeStringElement(serialDesc, 6, self.windowTitle);
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.root != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, KViewNode$$serializer.INSTANCE, self.root);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !self.autoSave) {
            output.encodeBooleanElement(serialDesc, 8, self.autoSave);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.screenshotPath != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, h0.f242a, self.screenshotPath);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.creationId != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, L.f223a, self.creationId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.chatId != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, L.f223a, self.chatId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.senderId != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, L.f223a, self.senderId);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 13) && self.rootCommentId == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 13, L.f223a, self.rootCommentId);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component10, reason: from getter */
    public final String getScreenshotPath() {
        return this.screenshotPath;
    }

    /* renamed from: component11, reason: from getter */
    public final Long getCreationId() {
        return this.creationId;
    }

    /* renamed from: component12, reason: from getter */
    public final Long getChatId() {
        return this.chatId;
    }

    /* renamed from: component13, reason: from getter */
    public final Long getSenderId() {
        return this.senderId;
    }

    /* renamed from: component14, reason: from getter */
    public final Long getRootCommentId() {
        return this.rootCommentId;
    }

    /* renamed from: component15, reason: from getter */
    public final AccountEntry getAccount() {
        return this.account;
    }

    public final List<ParseRule> component16() {
        return this.rules;
    }

    public final List<String> component17() {
        return this.subDirs;
    }

    /* renamed from: component2, reason: from getter */
    public final int getAndroidUserId() {
        return this.androidUserId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* renamed from: component5, reason: from getter */
    public final Long getUserId() {
        return this.userId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getActivity() {
        return this.activity;
    }

    /* renamed from: component7, reason: from getter */
    public final String getWindowTitle() {
        return this.windowTitle;
    }

    /* renamed from: component8, reason: from getter */
    public final KViewNode getRoot() {
        return this.root;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getAutoSave() {
        return this.autoSave;
    }

    public final ParseCache copy(String packageName, int androidUserId, String nickname, String uuid, Long userId, String activity, String windowTitle, KViewNode root, boolean autoSave, String screenshotPath, Long creationId, Long chatId, Long senderId, Long rootCommentId, AccountEntry account, List<ParseRule> rules, List<String> subDirs) {
        k.f(packageName, "packageName");
        k.f(activity, "activity");
        k.f(windowTitle, "windowTitle");
        k.f(rules, "rules");
        k.f(subDirs, "subDirs");
        return new ParseCache(packageName, androidUserId, nickname, uuid, userId, activity, windowTitle, root, autoSave, screenshotPath, creationId, chatId, senderId, rootCommentId, account, rules, subDirs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParseCache)) {
            return false;
        }
        ParseCache parseCache = (ParseCache) other;
        return k.b(this.packageName, parseCache.packageName) && this.androidUserId == parseCache.androidUserId && k.b(this.nickname, parseCache.nickname) && k.b(this.uuid, parseCache.uuid) && k.b(this.userId, parseCache.userId) && k.b(this.activity, parseCache.activity) && k.b(this.windowTitle, parseCache.windowTitle) && k.b(this.root, parseCache.root) && this.autoSave == parseCache.autoSave && k.b(this.screenshotPath, parseCache.screenshotPath) && k.b(this.creationId, parseCache.creationId) && k.b(this.chatId, parseCache.chatId) && k.b(this.senderId, parseCache.senderId) && k.b(this.rootCommentId, parseCache.rootCommentId) && k.b(this.account, parseCache.account) && k.b(this.rules, parseCache.rules) && k.b(this.subDirs, parseCache.subDirs);
    }

    public final AccountEntry getAccount() {
        return this.account;
    }

    public final String getActivity() {
        return this.activity;
    }

    public final int getAndroidUserId() {
        return this.androidUserId;
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

    public final String getNickname() {
        return this.nickname;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final KViewNode getRoot() {
        return this.root;
    }

    public final Long getRootCommentId() {
        return this.rootCommentId;
    }

    public final List<ParseRule> getRules() {
        return this.rules;
    }

    public final String getScreenshotPath() {
        return this.screenshotPath;
    }

    public final Long getSenderId() {
        return this.senderId;
    }

    public final List<String> getSubDirs() {
        return this.subDirs;
    }

    public final Long getUserId() {
        return this.userId;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getWindowTitle() {
        return this.windowTitle;
    }

    public int hashCode() {
        int iA = a.a(this.androidUserId, this.packageName.hashCode() * 31, 31);
        String str = this.nickname;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.uuid;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.userId;
        int iC = B7.a.c(B7.a.c((iHashCode2 + (l == null ? 0 : l.hashCode())) * 31, 31, this.activity), 31, this.windowTitle);
        KViewNode kViewNode = this.root;
        int iD = androidx.appfunctions.metadata.a.d((iC + (kViewNode == null ? 0 : kViewNode.hashCode())) * 31, 31, this.autoSave);
        String str3 = this.screenshotPath;
        int iHashCode3 = (iD + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l5 = this.creationId;
        int iHashCode4 = (iHashCode3 + (l5 == null ? 0 : l5.hashCode())) * 31;
        Long l9 = this.chatId;
        int iHashCode5 = (iHashCode4 + (l9 == null ? 0 : l9.hashCode())) * 31;
        Long l10 = this.senderId;
        int iHashCode6 = (iHashCode5 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.rootCommentId;
        int iHashCode7 = (iHashCode6 + (l11 == null ? 0 : l11.hashCode())) * 31;
        AccountEntry accountEntry = this.account;
        return this.subDirs.hashCode() + androidx.appfunctions.metadata.a.e(this.rules, (iHashCode7 + (accountEntry != null ? accountEntry.hashCode() : 0)) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ParseCache(packageName=");
        sb.append(this.packageName);
        sb.append(", androidUserId=");
        sb.append(this.androidUserId);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", uuid=");
        sb.append(this.uuid);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(", activity=");
        sb.append(this.activity);
        sb.append(", windowTitle=");
        sb.append(this.windowTitle);
        sb.append(", root=");
        sb.append(this.root);
        sb.append(", autoSave=");
        sb.append(this.autoSave);
        sb.append(", screenshotPath=");
        sb.append(this.screenshotPath);
        sb.append(", creationId=");
        sb.append(this.creationId);
        sb.append(", chatId=");
        sb.append(this.chatId);
        sb.append(", senderId=");
        sb.append(this.senderId);
        sb.append(", rootCommentId=");
        sb.append(this.rootCommentId);
        sb.append(", account=");
        sb.append(this.account);
        sb.append(", rules=");
        sb.append(this.rules);
        sb.append(", subDirs=");
        return B7.a.r(sb, this.subDirs, ')');
    }

    public ParseCache(String packageName, int i, String str, String str2, Long l, String activity, String windowTitle, KViewNode kViewNode, boolean z10, String str3, Long l5, Long l9, Long l10, Long l11, AccountEntry accountEntry, List<ParseRule> rules, List<String> subDirs) {
        k.f(packageName, "packageName");
        k.f(activity, "activity");
        k.f(windowTitle, "windowTitle");
        k.f(rules, "rules");
        k.f(subDirs, "subDirs");
        this.packageName = packageName;
        this.androidUserId = i;
        this.nickname = str;
        this.uuid = str2;
        this.userId = l;
        this.activity = activity;
        this.windowTitle = windowTitle;
        this.root = kViewNode;
        this.autoSave = z10;
        this.screenshotPath = str3;
        this.creationId = l5;
        this.chatId = l9;
        this.senderId = l10;
        this.rootCommentId = l11;
        this.account = accountEntry;
        this.rules = rules;
        this.subDirs = subDirs;
    }

    public ParseCache(String str, int i, String str2, String str3, Long l, String str4, String str5, KViewNode kViewNode, boolean z10, String str6, Long l5, Long l9, Long l10, Long l11, AccountEntry accountEntry, List list, List list2, int i6, e eVar) {
        this(str, i, (i6 & 4) != 0 ? null : str2, (i6 & 8) != 0 ? null : str3, (i6 & 16) != 0 ? null : l, str4, str5, (i6 & 128) != 0 ? null : kViewNode, (i6 & 256) != 0 ? true : z10, (i6 & 512) != 0 ? null : str6, (i6 & 1024) != 0 ? null : l5, (i6 & 2048) != 0 ? null : l9, (i6 & 4096) != 0 ? null : l10, (i6 & 8192) != 0 ? null : l11, (i6 & 16384) != 0 ? null : accountEntry, (32768 & i6) != 0 ? EmptyList.f4893a : list, (i6 & 65536) != 0 ? EmptyList.f4893a : list2);
    }
}
