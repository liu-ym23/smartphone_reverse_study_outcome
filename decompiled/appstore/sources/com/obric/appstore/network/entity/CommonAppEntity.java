package com.obric.appstore.network.entity;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.c0;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.google.common.primitives.Ints;
import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.common.UiType;
import java.util.List;
import kotlin.Metadata;
import kotlin.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.text.n;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\ba\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 }2\u00020\u0001:\u0001}B÷\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\u0003\u0012\b\b\u0002\u0010$\u001a\u00020\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\u0003\u0012\b\b\u0002\u0010&\u001a\u00020\u0003\u0012\b\b\u0002\u0010'\u001a\u00020\u0003¢\u0006\u0002\u0010(J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010:J\u0010\u0010Z\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010:J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\u0011\u0010_\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013HÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\t\u0010j\u001a\u00020\u0003HÆ\u0003J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\t\u0010l\u001a\u00020\u0003HÆ\u0003J\t\u0010m\u001a\u00020\u0003HÆ\u0003J\t\u0010n\u001a\u00020\u0003HÆ\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010:J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\t\u0010q\u001a\u00020\u0003HÆ\u0003J\t\u0010r\u001a\u00020\fHÆ\u0003J\t\u0010s\u001a\u00020\u0003HÆ\u0003J\u0006\u0010t\u001a\u00020uJ\u0080\u0003\u0010v\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010wJ\u0013\u0010x\u001a\u00020y2\b\u0010z\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010{\u001a\u00020\bHÖ\u0001J\t\u0010|\u001a\u00020\u0003HÖ\u0001R\u0016\u0010 \u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0016\u0010\u001e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u0011\u0010%\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\u0016\u0010#\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u0016\u0010$\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010*R\u0016\u0010\u001b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010*R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010*R\u0016\u0010\u001d\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010*R\u0016\u0010&\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010*R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010*R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010*R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010*R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u0016\u0010\u001c\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010*R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010*R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010*R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010*R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u00106R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010*R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010*R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010*R\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010*R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0016\u0010'\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010*R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010;\u001a\u0004\bH\u0010:R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010*R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010*R\u0016\u0010\u001f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010*R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010*\"\u0004\bM\u0010NR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010;\u001a\u0004\bO\u0010:R\u0016\u0010!\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010*R\u0016\u0010\"\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010*¨\u0006~"}, d2 = {"Lcom/obric/appstore/network/entity/CommonAppEntity;", "", "id", "", "deverId", "name", "version", "versionCode", "", AppPermissionActivity.EXTRA_APP_PKG, ServerElements.LOGO, ServerElements.SCORES, "", ServerElements.FILESIZE, "status", "ifGms", "source", "downloadUrl", "downloadUrlBackups", "", "icpNumber", "softType", "gameType", "recmdBrief", ServerElements.BRIEF, ServerElements.FILE_MD5, ServerElements.LABEL, ServerElements.DEVELOPER, "gradeDesc", "diffApk", "category", TraceStatsConsts.STATS_KEY_TRACE, "apkFile", "videoImg", "videoUrl", "cid1", "cid2", "channel", "dmUrl", ServerElements.SIGN, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApkFile", "()Ljava/lang/String;", "getBrief", "getCategory", "getChannel", "getCid1", "getCid2", "getDeveloper", "getDeverId", "getDiffApk", "getDmUrl", "getDownloadUrl", "getDownloadUrlBackups", "()Ljava/util/List;", "getFilemd5", "getFilesize", "getGameType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGradeDesc", "getIcpNumber", "getId", "getIfGms", "getLabel", "getLogo", "getName", "getPkg", "getRecmdBrief", "getScores", "()F", "getSign", "getSoftType", "getSource", "getStatus", "getTrace", "getVersion", "setVersion", "(Ljava/lang/String;)V", "getVersionCode", "getVideoImg", "getVideoUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component4", "component5", "component6", "component7", "component8", "component9", "convertAppInfo", "Lcom/bytedanceos/common/model/AppInfo;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/appstore/network/entity/CommonAppEntity;", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "Companion", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCommonAppEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonAppEntity.kt\ncom/obric/appstore/network/entity/CommonAppEntity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,143:1\n1#2:144\n*E\n"})
public final class CommonAppEntity {

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    private static final DiffUtil.ItemCallback DIFF_CALLBACK = null;

    @SerializedName("apk_file")
    @NotNull
    private final String apkFile;

    @SerializedName(ServerElements.BRIEF)
    @NotNull
    private final String brief;

    @SerializedName("category")
    @NotNull
    private final String category;

    @NotNull
    private final String channel;

    @SerializedName("cid_1")
    @NotNull
    private final String cid1;

    @SerializedName("cid_2")
    @NotNull
    private final String cid2;

    @SerializedName(ServerElements.DEVELOPER)
    @NotNull
    private final String developer;

    @SerializedName(ServerElements.DEVER_ID)
    @NotNull
    private final String deverId;

    @SerializedName("diffApk")
    @NotNull
    private final String diffApk;

    @SerializedName(ServerElements.DM_URL)
    @NotNull
    private final String dmUrl;

    @SerializedName(ServerElements.DOWNLOAD_URL)
    @Nullable
    private final String downloadUrl;

    @SerializedName(ServerElements.DOWNLOAD_URL_BACKUPS)
    @Nullable
    private final List<String> downloadUrlBackups;

    @SerializedName(ServerElements.FILE_MD5)
    @NotNull
    private final String filemd5;

    @SerializedName(ServerElements.FILESIZE)
    @NotNull
    private final String filesize;

    @SerializedName("gameType")
    @Nullable
    private final Integer gameType;

    @SerializedName("gradeDesc")
    @NotNull
    private final String gradeDesc;

    @SerializedName(ServerElements.ICP_NUMBER)
    @Nullable
    private final String icpNumber;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    @Nullable
    private final String f10966id;

    @SerializedName(ServerElements.IFGMS)
    @NotNull
    private final String ifGms;

    @SerializedName(ServerElements.LABEL)
    @Nullable
    private final List<Integer> label;

    @SerializedName(ServerElements.LOGO)
    @NotNull
    private final String logo;

    @SerializedName("name")
    @NotNull
    private final String name;

    @SerializedName("package")
    @NotNull
    private final String pkg;

    @SerializedName(ServerElements.RECMD_BRIEF)
    @NotNull
    private final String recmdBrief;

    @SerializedName(ServerElements.SCORES)
    private final float scores;

    @SerializedName(ServerElements.SIGN)
    @NotNull
    private final String sign;

    @SerializedName("soft_type")
    @Nullable
    private final Integer softType;

    @SerializedName("source")
    @NotNull
    private final String source;

    @SerializedName("status")
    @Nullable
    private final String status;

    @SerializedName(TraceStatsConsts.STATS_KEY_TRACE)
    @NotNull
    private final String trace;

    @SerializedName("version")
    @NotNull
    private String version;

    @SerializedName("version_code")
    @Nullable
    private final Integer versionCode;

    @SerializedName(ServerElements.VIDEO_IMG)
    @NotNull
    private final String videoImg;

    @SerializedName(ServerElements.VIDEO_PATH)
    @NotNull
    private final String videoUrl;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/appstore/network/entity/CommonAppEntity$Companion;", "", "()V", "DIFF_CALLBACK", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/obric/appstore/network/entity/CommonAppEntity;", "getDIFF_CALLBACK", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        @NotNull
        public final DiffUtil.ItemCallback getDIFF_CALLBACK() {
            return CommonAppEntity.access$getDIFF_CALLBACK$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        DIFF_CALLBACK = new CommonAppEntity$Companion$DIFF_CALLBACK$1();
    }

    public CommonAppEntity() {
        String r10 = null;
        String r11 = null;
        String r12 = null;
        String r13 = null;
        Integer r14 = null;
        String r15 = null;
        String r16 = null;
        float r17 = 0.0f;
        String r18 = null;
        String r19 = null;
        String r110 = null;
        String r111 = null;
        String r112 = null;
        List r113 = null;
        String r114 = null;
        Integer r115 = null;
        Integer r116 = null;
        String r117 = null;
        String r118 = null;
        String r20 = null;
        List r21 = null;
        String r22 = null;
        String r23 = null;
        String r24 = null;
        String r25 = null;
        String r26 = null;
        String r27 = null;
        String r28 = null;
        String r29 = null;
        String r30 = null;
        String r31 = null;
        String r32 = null;
        String r33 = null;
        String r34 = null;
        int r35 = -1;
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, 3, null);
    }

    public static final /* synthetic */ DiffUtil.ItemCallback access$getDIFF_CALLBACK$cp() {
        return DIFF_CALLBACK;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonAppEntity copy$default(CommonAppEntity r17, String r18, String r19, String r20, String r21, Integer r22, String r23, String r24, float r25, String r26, String r27, String r28, String r29, String r30, List r31, String r32, Integer r33, Integer r34, String r35, String r36, String r37, List r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49, String r50, String r51, int r52, int r53, Object r54) {
        if ((r52 & 1) == 0) goto L5;
        String r10 = r17.f10966id;
    L7:
        if ((r52 & 2) == 0) goto L9;
        String r11 = r17.deverId;
    L11:
        if ((r52 & 4) == 0) goto L13;
        String r12 = r17.name;
    L15:
        if ((r52 & 8) == 0) goto L17;
        String r13 = r17.version;
    L19:
        if ((r52 & 16) == 0) goto L21;
        Integer r14 = r17.versionCode;
    L23:
        if ((r52 & 32) == 0) goto L25;
        String r15 = r17.pkg;
    L27:
        if ((r52 & 64) == 0) goto L29;
        String r16 = r17.logo;
    L31:
        if ((r52 & 128) == 0) goto L33;
        float r55 = r17.scores;
    L35:
        if ((r52 & 256) == 0) goto L37;
        String r110 = r17.filesize;
    L39:
        if ((r52 & 512) == 0) goto L41;
        String r111 = r17.status;
    L43:
        if ((r52 & 1024) == 0) goto L45;
        String r112 = r17.ifGms;
    L47:
        if ((r52 & 2048) == 0) goto L49;
        String r113 = r17.source;
    L51:
        if ((r52 & 4096) == 0) goto L53;
        String r114 = r17.downloadUrl;
    L55:
        if ((r52 & 8192) == 0) goto L57;
        List r115 = r17.downloadUrlBackups;
    L58:
        List r310 = r115;
        if ((r52 & 16384) == 0) goto L61;
        String r116 = r17.icpNumber;
    L62:
        String r311 = r116;
        if ((r52 & UiType.FLAG_SETTINGS_CARD) == 0) goto L65;
        Integer r117 = r17.softType;
    L66:
        Integer r312 = r117;
        if ((r52 & 65536) == 0) goto L69;
        Integer r118 = r17.gameType;
    L70:
        Integer r313 = r118;
        if ((r52 & UiType.FLAG_PHONE_CARD) == 0) goto L73;
        String r119 = r17.recmdBrief;
    L74:
        String r314 = r119;
        if ((r52 & UiType.FLAG_TIMER_CARD) == 0) goto L77;
        String r120 = r17.brief;
    L78:
        String r315 = r120;
        if ((r52 & UiType.FLAG_WIFI_QRCODE_CARD) == 0) goto L81;
        String r121 = r17.filemd5;
    L82:
        String r316 = r121;
        if ((r52 & UiType.FLAG_APP_CHOOSER_CARD) == 0) goto L85;
        List r122 = r17.label;
    L86:
        List r317 = r122;
        if ((r52 & UiType.FLAG_REMOTE_CARD) == 0) goto L89;
        String r123 = r17.developer;
    L90:
        String r318 = r123;
        if ((r52 & UiType.FLAG_NO_FEEDBACK) == 0) goto L93;
        String r124 = r17.gradeDesc;
    L94:
        String r410 = r124;
        if ((r52 & UiType.FLAG_APPLET_CARD) == 0) goto L97;
        String r125 = r17.diffApk;
    L98:
        String r411 = r125;
        if ((r52 & 16777216) == 0) goto L101;
        String r126 = r17.category;
    L102:
        String r412 = r126;
        if ((r52 & 33554432) == 0) goto L105;
        String r127 = r17.trace;
    L106:
        String r413 = r127;
        if ((r52 & 67108864) == 0) goto L109;
        String r128 = r17.apkFile;
    L110:
        String r414 = r128;
        if ((r52 & 134217728) == 0) goto L113;
        String r129 = r17.videoImg;
    L114:
        String r415 = r129;
        if ((r52 & 268435456) == 0) goto L117;
        String r130 = r17.videoUrl;
    L118:
        String r416 = r130;
        if ((r52 & 536870912) == 0) goto L121;
        String r131 = r17.cid1;
    L122:
        String r417 = r131;
        if ((r52 & Ints.MAX_POWER_OF_TWO) == 0) goto L125;
        String r132 = r17.cid2;
    L127:
        if ((r52 & Integer.MIN_VALUE) == 0) goto L129;
        String r56 = r17.channel;
    L130:
        String r418 = r56;
        if ((r53 & 1) == 0) goto L133;
        String r57 = r17.dmUrl;
    L134:
        String r58 = r57;
        if ((r53 & 2) == 0) goto L137;
        String r59 = r17.sign;
    L139:
        return r17.copy(r10, r11, r12, r13, r14, r15, r16, r55, r110, r111, r112, r113, r114, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r416, r417, r132, r418, r58, r59);
    L137:
        r59 = r51;
        goto L139
    L133:
        r57 = r50;
        goto L134
    L129:
        r56 = r49;
        goto L130
    L125:
        r132 = r48;
        goto L127
    L121:
        r131 = r47;
        goto L122
    L117:
        r130 = r46;
        goto L118
    L113:
        r129 = r45;
        goto L114
    L109:
        r128 = r44;
        goto L110
    L105:
        r127 = r43;
        goto L106
    L101:
        r126 = r42;
        goto L102
    L97:
        r125 = r41;
        goto L98
    L93:
        r124 = r40;
        goto L94
    L89:
        r123 = r39;
        goto L90
    L85:
        r122 = r38;
        goto L86
    L81:
        r121 = r37;
        goto L82
    L77:
        r120 = r36;
        goto L78
    L73:
        r119 = r35;
        goto L74
    L69:
        r118 = r34;
        goto L70
    L65:
        r117 = r33;
        goto L66
    L61:
        r116 = r32;
        goto L62
    L57:
        r115 = r31;
        goto L58
    L53:
        r114 = r30;
        goto L55
    L49:
        r113 = r29;
        goto L51
    L45:
        r112 = r28;
        goto L47
    L41:
        r111 = r27;
        goto L43
    L37:
        r110 = r26;
        goto L39
    L33:
        r55 = r25;
        goto L35
    L29:
        r16 = r24;
        goto L31
    L25:
        r15 = r23;
        goto L27
    L21:
        r14 = r22;
        goto L23
    L17:
        r13 = r21;
        goto L19
    L13:
        r12 = r20;
        goto L15
    L9:
        r11 = r19;
        goto L11
    L5:
        r10 = r18;
        goto L7
    }

    @Nullable
    public final String component1() {
        return this.f10966id;
    }

    @Nullable
    public final String component10() {
        return this.status;
    }

    @NotNull
    public final String component11() {
        return this.ifGms;
    }

    @NotNull
    public final String component12() {
        return this.source;
    }

    @Nullable
    public final String component13() {
        return this.downloadUrl;
    }

    @Nullable
    public final List<String> component14() {
        return this.downloadUrlBackups;
    }

    @Nullable
    public final String component15() {
        return this.icpNumber;
    }

    @Nullable
    public final Integer component16() {
        return this.softType;
    }

    @Nullable
    public final Integer component17() {
        return this.gameType;
    }

    @NotNull
    public final String component18() {
        return this.recmdBrief;
    }

    @NotNull
    public final String component19() {
        return this.brief;
    }

    @NotNull
    public final String component2() {
        return this.deverId;
    }

    @NotNull
    public final String component20() {
        return this.filemd5;
    }

    @Nullable
    public final List<Integer> component21() {
        return this.label;
    }

    @NotNull
    public final String component22() {
        return this.developer;
    }

    @NotNull
    public final String component23() {
        return this.gradeDesc;
    }

    @NotNull
    public final String component24() {
        return this.diffApk;
    }

    @NotNull
    public final String component25() {
        return this.category;
    }

    @NotNull
    public final String component26() {
        return this.trace;
    }

    @NotNull
    public final String component27() {
        return this.apkFile;
    }

    @NotNull
    public final String component28() {
        return this.videoImg;
    }

    @NotNull
    public final String component29() {
        return this.videoUrl;
    }

    @NotNull
    public final String component3() {
        return this.name;
    }

    @NotNull
    public final String component30() {
        return this.cid1;
    }

    @NotNull
    public final String component31() {
        return this.cid2;
    }

    @NotNull
    public final String component32() {
        return this.channel;
    }

    @NotNull
    public final String component33() {
        return this.dmUrl;
    }

    @NotNull
    public final String component34() {
        return this.sign;
    }

    @NotNull
    public final String component4() {
        return this.version;
    }

    @Nullable
    public final Integer component5() {
        return this.versionCode;
    }

    @NotNull
    public final String component6() {
        return this.pkg;
    }

    @NotNull
    public final String component7() {
        return this.logo;
    }

    public final float component8() {
        return this.scores;
    }

    @NotNull
    public final String component9() {
        return this.filesize;
    }

    @NotNull
    public final AppInfo convertAppInfo() {
        AppInfo r10 = new AppInfo();
        r10.appId = this.f10966id;
        r10.appName = this.name;
        Integer r11 = this.versionCode;     // Catch: NumberFormatException -> L7
        if (r11 == null) goto L9;
        r10.appVersionCode = r11.intValue();     // Catch: NumberFormatException -> L7
    L9:
        r10.appVersionName = this.version;
        r10.appPackageName = this.pkg;
        r10.appIcon = this.logo;
        r10.appScores = this.scores;
        r10.appCategoryName = this.category;
        Long r12 = n.i(this.filesize);     // Catch: NumberFormatException -> L14
        if (r12 == null) goto L37;
        r10.appBytes = r12.longValue();     // Catch: NumberFormatException -> L14
    L37:
        String r13 = this.status;     // Catch: NumberFormatException -> L20
        if (r13 == null) goto L22;
        r10.mStatus = c0.b(r13);     // Catch: NumberFormatException -> L20
    L22:
        r10.fileMd5 = this.filemd5;
        r10.mIsNeedGms = q.b(this.ifGms, "1");
        r10.appDownloadUrl = this.downloadUrl;
        r10.appDownloadUrlBackups = this.downloadUrlBackups;
        r10.icp = this.icpNumber;
        r10.recmd_brief = this.recmdBrief;
        r10.appBrief = this.brief;
        r10.sha256 = this.sign;
        if (o.r(this.source) == false) goto L25;
        r10.appSource = "local";
    L35:
        Integer r14 = this.softType;     // Catch: NumberFormatException -> L30
        if (r14 == null) goto L32;
        r10.mAppType = r14.intValue();     // Catch: NumberFormatException -> L30
    L32:
        return r10;
    L30:
        e = move-exception;
        j.b(a.b(e));
        r10.mAppType = 0;
        goto L32
    L25:
        r10.appSource = this.source;
    L20:
        e = move-exception;
        e.printStackTrace();
    L14:
        e = move-exception;
        e.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    @NotNull
    public final CommonAppEntity copy(@Nullable String r37, @NotNull String r38, @NotNull String r39, @NotNull String r40, @Nullable Integer r41, @NotNull String r42, @NotNull String r43, float r44, @NotNull String r45, @Nullable String r46, @NotNull String r47, @NotNull String r48, @Nullable String r49, @Nullable List<String> r50, @Nullable String r51, @Nullable Integer r52, @Nullable Integer r53, @NotNull String r54, @NotNull String r55, @NotNull String r56, @Nullable List<Integer> r57, @NotNull String r58, @NotNull String r59, @NotNull String r60, @NotNull String r61, @NotNull String r62, @NotNull String r63, @NotNull String r64, @NotNull String r65, @NotNull String r66, @NotNull String r67, @NotNull String r68, @NotNull String r69, @NotNull String r70) {
        q.g(r38, "deverId");
        q.g(r39, "name");
        q.g(r40, "version");
        q.g(r42, AppPermissionActivity.EXTRA_APP_PKG);
        q.g(r43, ServerElements.LOGO);
        q.g(r45, ServerElements.FILESIZE);
        q.g(r47, "ifGms");
        q.g(r48, "source");
        q.g(r54, "recmdBrief");
        q.g(r55, ServerElements.BRIEF);
        q.g(r56, ServerElements.FILE_MD5);
        q.g(r58, ServerElements.DEVELOPER);
        q.g(r59, "gradeDesc");
        q.g(r60, "diffApk");
        q.g(r61, "category");
        q.g(r62, TraceStatsConsts.STATS_KEY_TRACE);
        q.g(r63, "apkFile");
        q.g(r64, "videoImg");
        q.g(r65, "videoUrl");
        q.g(r66, "cid1");
        q.g(r67, "cid2");
        q.g(r68, "channel");
        q.g(r69, "dmUrl");
        q.g(r70, ServerElements.SIGN);
        return new CommonAppEntity(r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CommonAppEntity) == true) goto L8;
        return false;
    L8:
        CommonAppEntity r11 = (CommonAppEntity) r10;
        if (q.b(this.f10966id, r11.f10966id) == true) goto L12;
        return false;
    L12:
        if (q.b(this.deverId, r11.deverId) == true) goto L15;
        return false;
    L15:
        if (q.b(this.name, r11.name) == true) goto L18;
        return false;
    L18:
        if (q.b(this.version, r11.version) == true) goto L21;
        return false;
    L21:
        if (q.b(this.versionCode, r11.versionCode) == true) goto L24;
        return false;
    L24:
        if (q.b(this.pkg, r11.pkg) == true) goto L27;
        return false;
    L27:
        if (q.b(this.logo, r11.logo) == true) goto L30;
        return false;
    L30:
        if (Float.compare(this.scores, r11.scores) == 0) goto L33;
        return false;
    L33:
        if (q.b(this.filesize, r11.filesize) == true) goto L36;
        return false;
    L36:
        if (q.b(this.status, r11.status) == true) goto L39;
        return false;
    L39:
        if (q.b(this.ifGms, r11.ifGms) == true) goto L42;
        return false;
    L42:
        if (q.b(this.source, r11.source) == true) goto L45;
        return false;
    L45:
        if (q.b(this.downloadUrl, r11.downloadUrl) == true) goto L48;
        return false;
    L48:
        if (q.b(this.downloadUrlBackups, r11.downloadUrlBackups) == true) goto L51;
        return false;
    L51:
        if (q.b(this.icpNumber, r11.icpNumber) == true) goto L54;
        return false;
    L54:
        if (q.b(this.softType, r11.softType) == true) goto L57;
        return false;
    L57:
        if (q.b(this.gameType, r11.gameType) == true) goto L60;
        return false;
    L60:
        if (q.b(this.recmdBrief, r11.recmdBrief) == true) goto L63;
        return false;
    L63:
        if (q.b(this.brief, r11.brief) == true) goto L66;
        return false;
    L66:
        if (q.b(this.filemd5, r11.filemd5) == true) goto L69;
        return false;
    L69:
        if (q.b(this.label, r11.label) == true) goto L72;
        return false;
    L72:
        if (q.b(this.developer, r11.developer) == true) goto L75;
        return false;
    L75:
        if (q.b(this.gradeDesc, r11.gradeDesc) == true) goto L78;
        return false;
    L78:
        if (q.b(this.diffApk, r11.diffApk) == true) goto L81;
        return false;
    L81:
        if (q.b(this.category, r11.category) == true) goto L84;
        return false;
    L84:
        if (q.b(this.trace, r11.trace) == true) goto L87;
        return false;
    L87:
        if (q.b(this.apkFile, r11.apkFile) == true) goto L90;
        return false;
    L90:
        if (q.b(this.videoImg, r11.videoImg) == true) goto L93;
        return false;
    L93:
        if (q.b(this.videoUrl, r11.videoUrl) == true) goto L96;
        return false;
    L96:
        if (q.b(this.cid1, r11.cid1) == true) goto L99;
        return false;
    L99:
        if (q.b(this.cid2, r11.cid2) == true) goto L102;
        return false;
    L102:
        if (q.b(this.channel, r11.channel) == true) goto L105;
        return false;
    L105:
        if (q.b(this.dmUrl, r11.dmUrl) == true) goto L108;
        return false;
    L108:
        if (q.b(this.sign, r11.sign) == true) goto L110;
        return false;
    L110:
        return true;
    }

    @NotNull
    public final String getApkFile() {
        return this.apkFile;
    }

    @NotNull
    public final String getBrief() {
        return this.brief;
    }

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    public final String getChannel() {
        return this.channel;
    }

    @NotNull
    public final String getCid1() {
        return this.cid1;
    }

    @NotNull
    public final String getCid2() {
        return this.cid2;
    }

    @NotNull
    public final String getDeveloper() {
        return this.developer;
    }

    @NotNull
    public final String getDeverId() {
        return this.deverId;
    }

    @NotNull
    public final String getDiffApk() {
        return this.diffApk;
    }

    @NotNull
    public final String getDmUrl() {
        return this.dmUrl;
    }

    @Nullable
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    @Nullable
    public final List<String> getDownloadUrlBackups() {
        return this.downloadUrlBackups;
    }

    @NotNull
    public final String getFilemd5() {
        return this.filemd5;
    }

    @NotNull
    public final String getFilesize() {
        return this.filesize;
    }

    @Nullable
    public final Integer getGameType() {
        return this.gameType;
    }

    @NotNull
    public final String getGradeDesc() {
        return this.gradeDesc;
    }

    @Nullable
    public final String getIcpNumber() {
        return this.icpNumber;
    }

    @Nullable
    public final String getId() {
        return this.f10966id;
    }

    @NotNull
    public final String getIfGms() {
        return this.ifGms;
    }

    @Nullable
    public final List<Integer> getLabel() {
        return this.label;
    }

    @NotNull
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPkg() {
        return this.pkg;
    }

    @NotNull
    public final String getRecmdBrief() {
        return this.recmdBrief;
    }

    public final float getScores() {
        return this.scores;
    }

    @NotNull
    public final String getSign() {
        return this.sign;
    }

    @Nullable
    public final Integer getSoftType() {
        return this.softType;
    }

    @NotNull
    public final String getSource() {
        return this.source;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final String getTrace() {
        return this.trace;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    @Nullable
    public final Integer getVersionCode() {
        return this.versionCode;
    }

    @NotNull
    public final String getVideoImg() {
        return this.videoImg;
    }

    @NotNull
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public int hashCode() {
        String r10 = this.f10966id;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = ((((((r12 * 31) + this.deverId.hashCode()) * 31) + this.name.hashCode()) * 31) + this.version.hashCode()) * 31;
        Integer r14 = this.versionCode;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (((((((((r13 + r15) * 31) + this.pkg.hashCode()) * 31) + this.logo.hashCode()) * 31) + Float.hashCode(this.scores)) * 31) + this.filesize.hashCode()) * 31;
        String r17 = this.status;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (((((r16 + r18) * 31) + this.ifGms.hashCode()) * 31) + this.source.hashCode()) * 31;
        String r20 = this.downloadUrl;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        List<String> r23 = this.downloadUrlBackups;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        String r26 = this.icpNumber;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (r25 + r27) * 31;
        Integer r29 = this.softType;
        if (r29 != null) goto L29;
        int r30 = 0;
    L30:
        int r31 = (r28 + r30) * 31;
        Integer r32 = this.gameType;
        if (r32 != null) goto L33;
        int r33 = 0;
    L34:
        int r34 = (((((((r31 + r33) * 31) + this.recmdBrief.hashCode()) * 31) + this.brief.hashCode()) * 31) + this.filemd5.hashCode()) * 31;
        List<Integer> r35 = this.label;
        if (r35 == null) goto L39;
        r11 = r35.hashCode();
    L39:
        return ((((((((((((((((((((((((((r34 + r11) * 31) + this.developer.hashCode()) * 31) + this.gradeDesc.hashCode()) * 31) + this.diffApk.hashCode()) * 31) + this.category.hashCode()) * 31) + this.trace.hashCode()) * 31) + this.apkFile.hashCode()) * 31) + this.videoImg.hashCode()) * 31) + this.videoUrl.hashCode()) * 31) + this.cid1.hashCode()) * 31) + this.cid2.hashCode()) * 31) + this.channel.hashCode()) * 31) + this.dmUrl.hashCode()) * 31) + this.sign.hashCode();
    L33:
        r33 = r32.hashCode();
        goto L34
    L29:
        r30 = r29.hashCode();
        goto L30
    L25:
        r27 = r26.hashCode();
        goto L26
    L21:
        r24 = r23.hashCode();
        goto L22
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final void setVersion(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.version = r10;
    }

    @NotNull
    public String toString() {
        return "CommonAppEntity(id=" + this.f10966id + ", deverId=" + this.deverId + ", name=" + this.name + ", version=" + this.version + ", versionCode=" + this.versionCode + ", pkg=" + this.pkg + ", logo=" + this.logo + ", scores=" + this.scores + ", filesize=" + this.filesize + ", status=" + this.status + ", ifGms=" + this.ifGms + ", source=" + this.source + ", downloadUrl=" + this.downloadUrl + ", downloadUrlBackups=" + this.downloadUrlBackups + ", icpNumber=" + this.icpNumber + ", softType=" + this.softType + ", gameType=" + this.gameType + ", recmdBrief=" + this.recmdBrief + ", brief=" + this.brief + ", filemd5=" + this.filemd5 + ", label=" + this.label + ", developer=" + this.developer + ", gradeDesc=" + this.gradeDesc + ", diffApk=" + this.diffApk + ", category=" + this.category + ", trace=" + this.trace + ", apkFile=" + this.apkFile + ", videoImg=" + this.videoImg + ", videoUrl=" + this.videoUrl + ", cid1=" + this.cid1 + ", cid2=" + this.cid2 + ", channel=" + this.channel + ", dmUrl=" + this.dmUrl + ", sign=" + this.sign + ')';
    }

    public CommonAppEntity(@Nullable String r17, @NotNull String r18, @NotNull String r19, @NotNull String r20, @Nullable Integer r21, @NotNull String r22, @NotNull String r23, float r24, @NotNull String r25, @Nullable String r26, @NotNull String r27, @NotNull String r28, @Nullable String r29, @Nullable List<String> r30, @Nullable String r31, @Nullable Integer r32, @Nullable Integer r33, @NotNull String r34, @NotNull String r35, @NotNull String r36, @Nullable List<Integer> r37, @NotNull String r38, @NotNull String r39, @NotNull String r40, @NotNull String r41, @NotNull String r42, @NotNull String r43, @NotNull String r44, @NotNull String r45, @NotNull String r46, @NotNull String r47, @NotNull String r48, @NotNull String r49, @NotNull String r50) {
        q.g(r18, "deverId");
        q.g(r19, "name");
        q.g(r20, "version");
        q.g(r22, AppPermissionActivity.EXTRA_APP_PKG);
        q.g(r23, ServerElements.LOGO);
        q.g(r25, ServerElements.FILESIZE);
        q.g(r27, "ifGms");
        q.g(r28, "source");
        q.g(r34, "recmdBrief");
        q.g(r35, ServerElements.BRIEF);
        q.g(r36, ServerElements.FILE_MD5);
        q.g(r38, ServerElements.DEVELOPER);
        q.g(r39, "gradeDesc");
        q.g(r40, "diffApk");
        q.g(r41, "category");
        q.g(r42, TraceStatsConsts.STATS_KEY_TRACE);
        q.g(r43, "apkFile");
        q.g(r44, "videoImg");
        q.g(r45, "videoUrl");
        q.g(r46, "cid1");
        q.g(r47, "cid2");
        q.g(r48, "channel");
        q.g(r49, "dmUrl");
        q.g(r50, ServerElements.SIGN);
        this.f10966id = r17;
        this.deverId = r18;
        this.name = r19;
        this.version = r20;
        this.versionCode = r21;
        this.pkg = r22;
        this.logo = r23;
        this.scores = r24;
        this.filesize = r25;
        this.status = r26;
        this.ifGms = r27;
        this.source = r28;
        this.downloadUrl = r29;
        this.downloadUrlBackups = r30;
        this.icpNumber = r31;
        this.softType = r32;
        this.gameType = r33;
        this.recmdBrief = r34;
        this.brief = r35;
        this.filemd5 = r36;
        this.label = r37;
        this.developer = r38;
        this.gradeDesc = r39;
        this.diffApk = r40;
        this.category = r41;
        this.trace = r42;
        this.apkFile = r43;
        this.videoImg = r44;
        this.videoUrl = r45;
        this.cid1 = r46;
        this.cid2 = r47;
        this.channel = r48;
        this.dmUrl = r49;
        this.sign = r50;
    }

    public /* synthetic */ CommonAppEntity(String r35, String r36, String r37, String r38, Integer r39, String r40, String r41, float r42, String r43, String r44, String r45, String r46, String r47, List r48, String r49, Integer r50, Integer r51, String r52, String r53, String r54, List r55, String r56, String r57, String r58, String r59, String r60, String r61, String r62, String r63, String r64, String r65, String r66, String r67, String r68, int r69, int r70, DefaultConstructorMarker r71) {
        if ((r69 & 1) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r69 & 2) == 0) goto L9;
        String r11 = "";
    L11:
        if ((r69 & 4) == 0) goto L13;
        String r12 = "";
    L15:
        if ((r69 & 8) == 0) goto L17;
        String r13 = "";
    L19:
        if ((r69 & 16) == 0) goto L21;
        Integer r14 = null;
    L23:
        if ((r69 & 32) == 0) goto L25;
        String r15 = "";
    L27:
        if ((r69 & 64) == 0) goto L29;
        String r16 = "";
    L31:
        if ((r69 & 128) == 0) goto L33;
        float r17 = 0.0f;
    L35:
        if ((r69 & 256) == 0) goto L37;
        String r18 = "";
    L39:
        if ((r69 & 512) == 0) goto L41;
        String r19 = null;
    L43:
        if ((r69 & 1024) == 0) goto L45;
        String r110 = "";
    L47:
        if ((r69 & 2048) == 0) goto L49;
        String r111 = "";
    L51:
        if ((r69 & 4096) == 0) goto L53;
        String r112 = null;
    L55:
        if ((r69 & 8192) == 0) goto L57;
        List r20 = null;
    L59:
        if ((r69 & 16384) == 0) goto L61;
        String r21 = null;
    L63:
        if ((r69 & UiType.FLAG_SETTINGS_CARD) == 0) goto L65;
        Integer r113 = null;
    L67:
        if ((r69 & 65536) == 0) goto L69;
        Integer r114 = null;
    L71:
        if ((r69 & UiType.FLAG_PHONE_CARD) == 0) goto L73;
        String r115 = "";
    L75:
        if ((r69 & UiType.FLAG_TIMER_CARD) == 0) goto L77;
        String r116 = "";
    L79:
        if ((r69 & UiType.FLAG_WIFI_QRCODE_CARD) == 0) goto L81;
        String r22 = "";
    L83:
        if ((r69 & UiType.FLAG_APP_CHOOSER_CARD) == 0) goto L85;
        List r23 = null;
    L87:
        if ((r69 & UiType.FLAG_REMOTE_CARD) == 0) goto L89;
        String r24 = "";
    L91:
        if ((r69 & UiType.FLAG_NO_FEEDBACK) == 0) goto L93;
        String r25 = "";
    L95:
        if ((r69 & UiType.FLAG_APPLET_CARD) == 0) goto L97;
        String r26 = "";
    L99:
        if ((r69 & 16777216) == 0) goto L101;
        String r27 = "";
    L103:
        if ((r69 & 33554432) == 0) goto L105;
        String r28 = "";
    L107:
        if ((r69 & 67108864) == 0) goto L109;
        String r29 = "";
    L111:
        if ((r69 & 134217728) == 0) goto L113;
        String r210 = "";
    L115:
        if ((r69 & 268435456) == 0) goto L117;
        String r211 = "";
    L119:
        if ((r69 & 536870912) == 0) goto L121;
        String r30 = "";
    L123:
        if ((r69 & Ints.MAX_POWER_OF_TWO) == 0) goto L125;
        String r31 = "";
    L127:
        if ((r69 & Integer.MIN_VALUE) == 0) goto L129;
        String r32 = "";
    L131:
        if ((r70 & 1) == 0) goto L133;
        String r33 = "";
    L135:
        if ((r70 & 2) == 0) goto L137;
        String r34 = "";
    L138:
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r20, r21, r113, r114, r115, r116, r22, r23, r24, r25, r26, r27, r28, r29, r210, r211, r30, r31, r32, r33, r34);
        return;
    L137:
        r34 = r68;
        goto L138
    L133:
        r33 = r67;
        goto L135
    L129:
        r32 = r66;
        goto L131
    L125:
        r31 = r65;
        goto L127
    L121:
        r30 = r64;
        goto L123
    L117:
        r211 = r63;
        goto L119
    L113:
        r210 = r62;
        goto L115
    L109:
        r29 = r61;
        goto L111
    L105:
        r28 = r60;
        goto L107
    L101:
        r27 = r59;
        goto L103
    L97:
        r26 = r58;
        goto L99
    L93:
        r25 = r57;
        goto L95
    L89:
        r24 = r56;
        goto L91
    L85:
        r23 = r55;
        goto L87
    L81:
        r22 = r54;
        goto L83
    L77:
        r116 = r53;
        goto L79
    L73:
        r115 = r52;
        goto L75
    L69:
        r114 = r51;
        goto L71
    L65:
        r113 = r50;
        goto L67
    L61:
        r21 = r49;
        goto L63
    L57:
        r20 = r48;
        goto L59
    L53:
        r112 = r47;
        goto L55
    L49:
        r111 = r46;
        goto L51
    L45:
        r110 = r45;
        goto L47
    L41:
        r19 = r44;
        goto L43
    L37:
        r18 = r43;
        goto L39
    L33:
        r17 = r42;
        goto L35
    L29:
        r16 = r41;
        goto L31
    L25:
        r15 = r40;
        goto L27
    L21:
        r14 = r39;
        goto L23
    L17:
        r13 = r38;
        goto L19
    L13:
        r12 = r37;
        goto L15
    L9:
        r11 = r36;
        goto L11
    L5:
        r10 = r35;
        goto L7
    }
}
