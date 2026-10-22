package com.stepos.stepclaw.provider.handlers;

import a.a;
import a8.b;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import b7.c;
import c5.o;
import c5.s;
import c5.t;
import c5.w;
import c5.x;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.provider.backend.IRootfsAccess;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import com.stepos.stepclaw.provider.contract.ExtensionCallContractKt;
import com.stepos.stepclaw.provider.contract.OperationResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import m5.k;
import org.json.JSONException;
import org.json.JSONObject;
import x5.h;
import x5.j;
import x5.l;
import x5.m;
import x5.n;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b0\u0018\u0000 `2\u00020\u0001:\u0001`B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0015\u0010\u0016J5\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010 \u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u001b\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\"H\u0002¢\u0006\u0004\b#\u0010$JI\u0010-\u001a\u00020,2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060(2\u0006\u0010*\u001a\u00020\u001e2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\"H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00102\u001a\u0002012\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b2\u00103J\u0019\u00105\u001a\u0004\u0018\u00010\u00062\u0006\u00104\u001a\u00020\u0006H\u0002¢\u0006\u0004\b5\u00106J\u0019\u00107\u001a\u0004\u0018\u00010\u00062\u0006\u00104\u001a\u00020\u0006H\u0002¢\u0006\u0004\b7\u00106J\u001f\u00108\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u001eH\u0002¢\u0006\u0004\b8\u00109JA\u0010<\u001a\u00020,2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b<\u0010=JQ\u0010B\u001a\u00020\u00062\b\u0010>\u001a\u0004\u0018\u00010\u00062\b\u0010?\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010@\u001a\u0004\u0018\u00010\u00062\u0006\u0010A\u001a\u00020\u0006H\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\bD\u0010\u0010J\u0019\u0010E\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\bG\u0010\u0010J\u0017\u0010H\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\bH\u0010\u0010J\u0017\u0010I\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\bI\u0010\u0010J\u0019\u0010J\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bJ\u0010KJ\u001f\u0010N\u001a\u00020\r2\u0006\u0010L\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u0006H\u0002¢\u0006\u0004\bN\u0010OJ\u001f\u0010P\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\bP\u0010!J\u0017\u0010Q\u001a\u00020/2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\bQ\u0010RJ\u0017\u0010S\u001a\u00020\u001e2\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\bS\u0010TJ\u0019\u0010U\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\bU\u00106J\u0019\u0010V\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\bV\u0010WJ\u0019\u0010X\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\bX\u0010WR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010YR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010ZR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010[R\u0014\u0010\\\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010^\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b^\u0010[R\u0014\u0010_\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b_\u0010[¨\u0006a"}, d2 = {"Lcom/stepos/stepclaw/provider/handlers/SkillsHandler;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Landroid/content/Context;", "context", "Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;", "rootfs", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "authority", "<init>", "(Landroid/content/Context;Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;Ljava/lang/String;)V", "Landroid/database/Cursor;", "query", "()Landroid/database/Cursor;", "Landroid/os/Bundle;", ExtensionCallContract.KEY_EXTRAS, "operation", "(Landroid/os/Bundle;)Landroid/os/Bundle;", "Landroid/content/ContentValues;", "values", "catalogDescription", "Landroid/net/Uri;", ExtensionCallContract.OP_INSTALL, "(Landroid/content/ContentValues;Landroid/os/Bundle;Ljava/lang/String;)Landroid/net/Uri;", "skillId", "metaExtras", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ExtensionCallContract.OP_UPDATE, "(Ljava/lang/String;Landroid/content/ContentValues;Landroid/os/Bundle;Ljava/lang/String;)I", "delete", "(Ljava/lang/String;)I", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "enable", ExtensionCallContract.OP_SET_ENABLE, "(Ljava/lang/String;Z)I", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "loadSkillEnabledMap", "()Ljava/util/Map;", "base", "Landroid/database/MatrixCursor;", "cursor", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen", "isBuiltinDir", "enabledById", "Lb5/a0;", "listSkillsFromDir", "(Ljava/lang/String;Landroid/database/MatrixCursor;Ljava/util/Set;ZLjava/util/Map;)V", "Ljava/io/File;", "dir", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "dirLastModified", "(Ljava/io/File;)J", "skillPath", "readMergedMetaVersion", "(Ljava/lang/String;)Ljava/lang/String;", "readMetaCatalogDescription", "readSourceStorageKey", "(Ljava/lang/String;Z)Ljava/lang/String;", ExtensionCallContract.SOURCE, "businessVersion", "writeSkillMeta", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;)V", "oldMetaRaw", "packagedMetaAfterExtract", "skillMdFallbackVersion", "skillDirForMergedJson", "mergeSkillMetaAfterUpdate", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "installOperation", "resolveId", "(Landroid/os/Bundle;)Ljava/lang/String;", "updateOperation", "uninstallOperation", "setEnableOperation", ConfigIpcContract.KEY_OK, "(Ljava/lang/String;)Landroid/os/Bundle;", "code", "msg", "err", "(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;", "setEnableLocked", "managedSkillDirOnDisk", "(Ljava/lang/String;)Ljava/io/File;", "skillRootHasAnyFile", "(Ljava/io/File;)Z", "readInstallVersionFromSkillMd", "requireContentValuesId", "(Landroid/content/ContentValues;)Ljava/lang/String;", "requireContentValuesZipUri", "Landroid/content/Context;", "Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;", "Ljava/lang/String;", "fsLock", "Ljava/lang/Object;", "managedBase", "builtinBase", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SkillsHandler {
    private static final int DESC_MAX_LEN = 800;
    private static final String TAG = "SkillsHandler";
    private final String authority;
    private final String builtinBase;
    private final Context context;
    private final Object fsLock;
    private final String managedBase;
    private final IRootfsAccess rootfs;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final l atxHeading = new l("^#{1,6}\\s+(.+)$", m.f6303c);

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002)*B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u000bJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0012\u0010\u000bJ\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0015\u0010\u000bJ\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0017\u0010\u000bJ!\u0010\u001c\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010 \u001a\u00020\u001d2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/stepos/stepclaw/provider/handlers/SkillsHandler$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "lines", "frontmatterContentLines", "(Ljava/util/List;)Ljava/util/List;", "line", "trimYamlLine", "(Ljava/lang/String;)Ljava/lang/String;", "text", "stripLeadingYamlFrontmatter", "body", "firstMarkdownAtxTitle", "parseFrontmatterNameField", "raw", "normalizeSkillMd$step_runtime_release", "normalizeSkillMd", "skillMd", "descriptionFromMarkdownBody$step_runtime_release", "descriptionFromMarkdownBody", "descriptionFallbackAfterHeadings$step_runtime_release", "descriptionFallbackAfterHeadings", "skillId", "resolveSkillDisplayName$step_runtime_release", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "resolveSkillDisplayName", "Lcom/stepos/stepclaw/provider/handlers/SkillsHandler$Companion$SkillMdFrontmatter;", "parseSkillMdFrontmatter$step_runtime_release", "(Ljava/lang/String;)Lcom/stepos/stepclaw/provider/handlers/SkillsHandler$Companion$SkillMdFrontmatter;", "parseSkillMdFrontmatter", "TAG", "Ljava/lang/String;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "DESC_MAX_LEN", "I", "Lx5/l;", "atxHeading", "Lx5/l;", "SkillMdFrontmatter", "YamlFm", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {

        /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/stepos/stepclaw/provider/handlers/SkillsHandler$Companion$SkillMdFrontmatter;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "version", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "description", "tags", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getVersion", "()Ljava/lang/String;", "getDescription", "getTags", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SkillMdFrontmatter {
            private final String description;
            private final List<String> tags;
            private final String version;

            public SkillMdFrontmatter() {
                this(null, null, null, 7, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SkillMdFrontmatter copy$default(SkillMdFrontmatter skillMdFrontmatter, String str, String str2, List list, int i8, Object obj) {
                if ((i8 & 1) != 0) {
                    str = skillMdFrontmatter.version;
                }
                if ((i8 & 2) != 0) {
                    str2 = skillMdFrontmatter.description;
                }
                if ((i8 & 4) != 0) {
                    list = skillMdFrontmatter.tags;
                }
                return skillMdFrontmatter.copy(str, str2, list);
            }

            /* renamed from: component1, reason: from getter */
            public final String getVersion() {
                return this.version;
            }

            /* renamed from: component2, reason: from getter */
            public final String getDescription() {
                return this.description;
            }

            public final List<String> component3() {
                return this.tags;
            }

            public final SkillMdFrontmatter copy(String version, String description, List<String> tags) {
                p.e(tags, "tags");
                return new SkillMdFrontmatter(version, description, tags);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SkillMdFrontmatter)) {
                    return false;
                }
                SkillMdFrontmatter skillMdFrontmatter = (SkillMdFrontmatter) other;
                return p.a(this.version, skillMdFrontmatter.version) && p.a(this.description, skillMdFrontmatter.description) && p.a(this.tags, skillMdFrontmatter.tags);
            }

            public final String getDescription() {
                return this.description;
            }

            public final List<String> getTags() {
                return this.tags;
            }

            public final String getVersion() {
                return this.version;
            }

            public int hashCode() {
                String str = this.version;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.description;
                return this.tags.hashCode() + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
            }

            public String toString() {
                String str = this.version;
                String str2 = this.description;
                List<String> list = this.tags;
                StringBuilder sbV = b.v("SkillMdFrontmatter(version=", str, ", description=", str2, ", tags=");
                sbV.append(list);
                sbV.append(")");
                return sbV.toString();
            }

            public SkillMdFrontmatter(String str, String str2, List<String> tags) {
                p.e(tags, "tags");
                this.version = str;
                this.description = str2;
                this.tags = tags;
            }

            public /* synthetic */ SkillMdFrontmatter(String str, String str2, List list, int i8, i iVar) {
                this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : str2, (i8 & 4) != 0 ? s.f1092a : list);
            }
        }

        /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/stepos/stepclaw/provider/handlers/SkillsHandler$Companion$YamlFm;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Lx5/l;", "VERSION", "Lx5/l;", "getVERSION", "()Lx5/l;", "DESCRIPTION", "getDESCRIPTION", "TAGS", "getTAGS", "NAME", "getNAME", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class YamlFm {
            private static final l DESCRIPTION;
            public static final YamlFm INSTANCE = new YamlFm();
            private static final l NAME;
            private static final l TAGS;
            private static final l VERSION;

            static {
                m mVar = m.f6302b;
                VERSION = new l("^version\\s*:\\s*(.*)$", mVar);
                DESCRIPTION = new l("^description\\s*:\\s*(.*)$", mVar);
                TAGS = new l("^tags\\s*:\\s*(.*)$", mVar);
                NAME = new l("^name\\s*:\\s*(.*)$", mVar);
            }

            private YamlFm() {
            }

            public final l getDESCRIPTION() {
                return DESCRIPTION;
            }

            public final l getNAME() {
                return NAME;
            }

            public final l getTAGS() {
                return TAGS;
            }

            public final l getVERSION() {
                return VERSION;
            }
        }

        public /* synthetic */ Companion(i iVar) {
            this();
        }

        private final String firstMarkdownAtxTitle(String body) {
            j jVarB = l.b(SkillsHandler.atxHeading, body);
            if (jVarB != null) {
                String string = n.T1((String) ((h) jVarB.a()).get(1)).toString();
                if (!n.t1(string)) {
                    return string;
                }
            }
            return null;
        }

        private final List<String> frontmatterContentLines(List<String> lines) {
            Object next;
            if (lines.isEmpty() || !p.a(n.T1((String) c5.m.u0(lines)).toString(), "---")) {
                return null;
            }
            Iterator it = c5.m.r0(new x(0, new c(5, lines)), 1).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (p.a(n.T1((String) ((w) next).f1096b).toString(), "---")) {
                    break;
                }
            }
            w wVar = (w) next;
            Integer numValueOf = wVar != null ? Integer.valueOf(wVar.f1095a) : null;
            if (numValueOf != null) {
                return lines.subList(1, numValueOf.intValue());
            }
            List<String> listR0 = c5.m.r0(lines, 1);
            if (listR0.isEmpty()) {
                return s.f1092a;
            }
            Iterator<String> it2 = listR0.iterator();
            int i8 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i8 = -1;
                    break;
                }
                String input = n.T1(it2.next()).toString();
                Pattern patternCompile = Pattern.compile("^#{1,6}\\s+.+$");
                p.d(patternCompile, "compile(...)");
                p.e(input, "input");
                if (patternCompile.matcher(input).matches()) {
                    break;
                }
                i8++;
            }
            return i8 >= 0 ? listR0.subList(0, i8) : listR0;
        }

        private final String parseFrontmatterNameField(String text) {
            List<String> listFrontmatterContentLines = frontmatterContentLines(n.y1(text));
            if (listFrontmatterContentLines == null) {
                return null;
            }
            Iterator<String> it = listFrontmatterContentLines.iterator();
            while (it.hasNext()) {
                j jVarD = YamlFm.INSTANCE.getNAME().d(trimYamlLine(it.next()));
                if (jVarD != null) {
                    String strD1 = n.D1(n.D1(n.T1((String) ((h) jVarD.a()).get(1)).toString(), "\""), "'");
                    if (n.t1(strD1)) {
                        return null;
                    }
                    return strD1;
                }
            }
            return null;
        }

        private final String stripLeadingYamlFrontmatter(String text) {
            Object next;
            List listY1 = n.y1(text);
            if (listY1.isEmpty() || !p.a(n.T1((String) c5.m.u0(listY1)).toString(), "---")) {
                return text;
            }
            Iterator it = c5.m.r0(new x(0, new c(5, listY1)), 1).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (p.a(n.T1((String) ((w) next).f1096b).toString(), "---")) {
                    break;
                }
            }
            w wVar = (w) next;
            Integer numValueOf = wVar != null ? Integer.valueOf(wVar.f1095a) : null;
            if (numValueOf != null) {
                return c5.m.A0(c5.m.r0(listY1, numValueOf.intValue() + 1), "\n", null, null, null, 62);
            }
            List listR0 = c5.m.r0(listY1, 1);
            Iterator it2 = listR0.iterator();
            int i8 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i8 = -1;
                    break;
                }
                String input = n.T1((String) it2.next()).toString();
                Pattern patternCompile = Pattern.compile("^#{1,6}\\s+.+$");
                p.d(patternCompile, "compile(...)");
                p.e(input, "input");
                if (patternCompile.matcher(input).matches()) {
                    break;
                }
                i8++;
            }
            return i8 >= 0 ? c5.m.A0(c5.m.r0(listR0, i8), "\n", null, null, null, 62) : SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }

        private final String trimYamlLine(String line) {
            return n.X1(n.T1(line).toString(), 65279);
        }

        public final String descriptionFallbackAfterHeadings$step_runtime_release(String skillMd) {
            p.e(skillMd, "skillMd");
            if (n.t1(skillMd)) {
                return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            String strStripLeadingYamlFrontmatter = stripLeadingYamlFrontmatter(normalizeSkillMd$step_runtime_release(skillMd));
            Pattern patternCompile = Pattern.compile("^#{1,6}\\s+.*$");
            p.d(patternCompile, "compile(...)");
            List listY1 = n.y1(strStripLeadingYamlFrontmatter);
            ArrayList arrayList = new ArrayList(o.n0(listY1, 10));
            Iterator it = listY1.iterator();
            while (it.hasNext()) {
                arrayList.add(n.T1((String) it.next()).toString());
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i8 = 0;
            while (i8 < size) {
                Object obj = arrayList.get(i8);
                i8++;
                String str = (String) obj;
                if (str.length() > 0 && !patternCompile.matcher(str).matches()) {
                    arrayList2.add(obj);
                }
            }
            return arrayList2.isEmpty() ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : n.T1(n.Q1(SkillsHandler.DESC_MAX_LEN, c5.m.A0(arrayList2, " ", null, null, null, 62))).toString();
        }

        public final String descriptionFromMarkdownBody$step_runtime_release(String skillMd) {
            p.e(skillMd, "skillMd");
            if (n.t1(skillMd)) {
                return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            List listY1 = n.y1(stripLeadingYamlFrontmatter(skillMd));
            int i8 = 0;
            while (i8 < listY1.size() && n.t1((CharSequence) listY1.get(i8))) {
                i8++;
            }
            if (i8 < listY1.size() && u.c1(n.T1((String) listY1.get(i8)).toString(), "#", false)) {
                do {
                    i8++;
                    if (i8 >= listY1.size()) {
                        break;
                    }
                } while (n.t1((CharSequence) listY1.get(i8)));
            }
            while (i8 < listY1.size()) {
                String string = n.T1((String) listY1.get(i8)).toString();
                if (string.length() == 0) {
                    i8++;
                } else if (u.c1(string, "#", false)) {
                    do {
                        i8++;
                        if (i8 < listY1.size()) {
                        }
                    } while (n.t1((CharSequence) listY1.get(i8)));
                } else {
                    StringBuilder sb = new StringBuilder();
                    while (i8 < listY1.size()) {
                        String string2 = n.T1((String) listY1.get(i8)).toString();
                        if (string2.length() == 0 || u.c1(string2, "#", false)) {
                            break;
                        }
                        if (sb.length() > 0) {
                            sb.append(' ');
                        }
                        sb.append(string2);
                        i8++;
                    }
                    String string3 = sb.toString();
                    p.d(string3, "toString(...)");
                    String string4 = n.T1(string3).toString();
                    if (string4.length() > 0) {
                        return n.Q1(SkillsHandler.DESC_MAX_LEN, string4);
                    }
                }
            }
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }

        public final String normalizeSkillMd$step_runtime_release(String raw) {
            String strX1;
            return (raw == null || (strX1 = n.X1(u.a1(raw, "\r\n", "\n"), 65279)) == null) ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : strX1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [c5.s] */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r2v18, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v21, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r2v22, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r2v3 */
        public final SkillMdFrontmatter parseSkillMdFrontmatter$step_runtime_release(String skillMd) {
            if (skillMd == null || n.t1(skillMd)) {
                return new SkillMdFrontmatter(null, null, null, 7, null);
            }
            List<String> listFrontmatterContentLines = frontmatterContentLines(n.y1(normalizeSkillMd$step_runtime_release(skillMd)));
            if (listFrontmatterContentLines == null) {
                return new SkillMdFrontmatter(null, null, null, 7, null);
            }
            ?? arrayList = s.f1092a;
            int i8 = 0;
            String strD1 = null;
            String string = null;
            while (i8 < listFrontmatterContentLines.size()) {
                String strTrimYamlLine = trimYamlLine(listFrontmatterContentLines.get(i8));
                YamlFm yamlFm = YamlFm.INSTANCE;
                if (yamlFm.getVERSION().d(strTrimYamlLine) != null) {
                    j jVarD = yamlFm.getVERSION().d(strTrimYamlLine);
                    p.b(jVarD);
                    strD1 = n.D1(n.D1(n.T1((String) ((h) jVarD.a()).get(1)).toString(), "\""), "'");
                    if (n.t1(strD1)) {
                        strD1 = null;
                    }
                } else if (yamlFm.getDESCRIPTION().d(strTrimYamlLine) != null) {
                    j jVarD2 = yamlFm.getDESCRIPTION().d(strTrimYamlLine);
                    p.b(jVarD2);
                    String string2 = n.T1((String) ((h) jVarD2.a()).get(1)).toString();
                    if (p.a(string2, "|") || p.a(string2, ">")) {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            i8++;
                            if (i8 >= listFrontmatterContentLines.size()) {
                                break;
                            }
                            String str = listFrontmatterContentLines.get(i8);
                            if (!u.c1(str, "  ", false) && (n.t1(str) || str.charAt(0) != ' ')) {
                                break;
                            }
                            sb.append(n.T1(str).toString());
                            sb.append('\n');
                        }
                        String string3 = sb.toString();
                        p.d(string3, "toString(...)");
                        string = n.T1(string3).toString();
                        if (n.t1(string)) {
                            string = null;
                        }
                    } else {
                        string = n.D1(n.D1(string2, "\""), "'");
                        if (n.t1(string)) {
                            string = null;
                        }
                    }
                } else if (yamlFm.getTAGS().d(strTrimYamlLine) != null) {
                    j jVarD3 = yamlFm.getTAGS().d(strTrimYamlLine);
                    p.b(jVarD3);
                    String string4 = n.T1((String) ((h) jVarD3.a()).get(1)).toString();
                    if (u.c1(string4, "[", false)) {
                        List listG1 = n.G1(n.T1(n.P1(n.B1(string4, "["), "]")).toString(), new String[]{","}, 0, 6);
                        ArrayList arrayList2 = new ArrayList(o.n0(listG1, 10));
                        Iterator it = listG1.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(n.D1(n.D1(n.T1((String) it.next()).toString(), "\""), "'"));
                        }
                        arrayList = new ArrayList();
                        int size = arrayList2.size();
                        int i9 = 0;
                        while (i9 < size) {
                            Object obj = arrayList2.get(i9);
                            i9++;
                            if (((String) obj).length() > 0) {
                                arrayList.add(obj);
                            }
                        }
                    } else if (string4.length() == 0) {
                        i8++;
                        arrayList = new ArrayList();
                        while (i8 < listFrontmatterContentLines.size()) {
                            String string5 = n.T1(listFrontmatterContentLines.get(i8)).toString();
                            if (u.c1(string5, "-", false)) {
                                arrayList.add(n.D1(n.D1(n.T1(n.B1(string5, "-")).toString(), "\""), "'"));
                            } else if (string5.length() == 0) {
                            }
                            i8++;
                        }
                    } else {
                        List listG12 = n.G1(string4, new String[]{","}, 0, 6);
                        ArrayList arrayList3 = new ArrayList(o.n0(listG12, 10));
                        Iterator it2 = listG12.iterator();
                        while (it2.hasNext()) {
                            arrayList3.add(n.D1(n.D1(n.T1((String) it2.next()).toString(), "\""), "'"));
                        }
                        arrayList = new ArrayList();
                        int size2 = arrayList3.size();
                        int i10 = 0;
                        while (i10 < size2) {
                            Object obj2 = arrayList3.get(i10);
                            i10++;
                            if (((String) obj2).length() > 0) {
                                arrayList.add(obj2);
                            }
                        }
                    }
                }
                i8++;
            }
            return new SkillMdFrontmatter(strD1, string, arrayList);
        }

        public final String resolveSkillDisplayName$step_runtime_release(String skillMd, String skillId) {
            p.e(skillId, "skillId");
            if (skillMd != null && !n.t1(skillMd)) {
                String strA1 = u.a1(skillMd, "\r\n", "\n");
                String frontmatterNameField = parseFrontmatterNameField(strA1);
                if (frontmatterNameField != null && !n.t1(frontmatterNameField)) {
                    return frontmatterNameField;
                }
                String strFirstMarkdownAtxTitle = firstMarkdownAtxTitle(stripLeadingYamlFrontmatter(strA1));
                if (strFirstMarkdownAtxTitle != null && !n.t1(strFirstMarkdownAtxTitle)) {
                    return strFirstMarkdownAtxTitle;
                }
            }
            return skillId;
        }

        private Companion() {
        }
    }

    public SkillsHandler(Context context, IRootfsAccess rootfs, String authority) {
        p.e(context, "context");
        p.e(rootfs, "rootfs");
        p.e(authority, "authority");
        this.context = context;
        this.rootfs = rootfs;
        this.authority = authority;
        this.fsLock = new Object();
        this.managedBase = "root/.openclaw/skills";
        this.builtinBase = "usr/local/lib/node_modules/openclaw/skills";
    }

    private final long dirLastModified(File dir) {
        if (!dir.exists() || !dir.isDirectory()) {
            return 0L;
        }
        Long l3 = null;
        m5.h hVar = new m5.h(new m5.j(dir, k.f3923a, null));
        if (hVar.hasNext()) {
            Long lValueOf = Long.valueOf(((File) hVar.next()).lastModified());
            loop0: while (true) {
                l3 = lValueOf;
                while (hVar.hasNext()) {
                    lValueOf = Long.valueOf(((File) hVar.next()).lastModified());
                    if (l3.compareTo(lValueOf) < 0) {
                        break;
                    }
                }
            }
        }
        return l3 != null ? l3.longValue() : dir.lastModified();
    }

    private final Bundle err(String code, String msg) {
        return OperationResult.INSTANCE.failure(code, msg);
    }

    public static /* synthetic */ Uri install$default(SkillsHandler skillsHandler, ContentValues contentValues, Bundle bundle, String str, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            bundle = null;
        }
        if ((i8 & 4) != 0) {
            str = null;
        }
        return skillsHandler.install(contentValues, bundle, str);
    }

    private final Bundle installOperation(Bundle extras) {
        Object objO;
        String string;
        String strResolveExtensionSkillId = ExtensionCallContractKt.resolveExtensionSkillId(extras);
        String str = null;
        if (strResolveExtensionSkillId == null) {
            ALog.w$default(TAG, "skill install (call): MISSING_ID keys=" + extras.keySet(), null, 4, null);
            return err("MISSING_ID", "id required");
        }
        String strResolveExtensionZipUri = ExtensionCallContractKt.resolveExtensionZipUri(extras);
        if (strResolveExtensionZipUri == null) {
            ALog.w$default(TAG, "skill install (call): MISSING_ZIP_URI id=" + strResolveExtensionSkillId + " keys=" + extras.keySet(), null, 4, null);
            return err("MISSING_ZIP_URI", "zip_uri required");
        }
        String string2 = extras.getString(ExtensionCallContract.SOURCE);
        if (string2 == null) {
            string2 = "local";
        }
        String string3 = extras.getString("version");
        String str2 = string3 == null ? AbstractJsonLexerKt.NULL : string3;
        StringBuilder sbV = b.v("skill install (call): op=install skillId=", strResolveExtensionSkillId, " source=", string2, " version=");
        sbV.append(str2);
        sbV.append(" zipUri=");
        sbV.append(strResolveExtensionZipUri);
        ALog.i$default(TAG, sbV.toString(), null, 4, null);
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", strResolveExtensionSkillId);
        contentValues.put(ExtensionCallContract.ZIP_URI, strResolveExtensionZipUri);
        contentValues.put(ExtensionCallContract.SOURCE, string2);
        if (string3 != null && !n.t1(string3)) {
            contentValues.put("version", string3);
        }
        Bundle bundle = extras.getBundle(ExtensionCallContract.KEY_EXTRAS);
        String string4 = extras.getString(ExtensionCallContract.CATALOG_DESCRIPTION);
        if (string4 != null && (string = n.T1(string4).toString()) != null && string.length() > 0) {
            str = string;
        }
        try {
            install(contentValues, bundle, str);
            objO = ok(strResolveExtensionSkillId);
        } catch (Throwable th) {
            objO = a.o(th);
        }
        Throwable thA = b5.i.a(objO);
        if (thA != null) {
            ALog.e(TAG, b.p("skill install (call) failed: skillId=", strResolveExtensionSkillId, " zipUri=", strResolveExtensionZipUri), thA);
            String message = thA.getMessage();
            if (message == null) {
                message = thA.getClass().getSimpleName();
            }
            objO = err("INSTALL_FAILED", message);
        }
        return (Bundle) objO;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void listSkillsFromDir(java.lang.String r26, android.database.MatrixCursor r27, java.util.Set<java.lang.String> r28, boolean r29, java.util.Map<java.lang.String, java.lang.Boolean> r30) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.provider.handlers.SkillsHandler.listSkillsFromDir(java.lang.String, android.database.MatrixCursor, java.util.Set, boolean, java.util.Map):void");
    }

    private final Map<String, Boolean> loadSkillEnabledMap() {
        JSONObject jSONObjectOptJSONObject;
        String rootfsFile = this.rootfs.readRootfsFile("root/.openclaw/openclaw.json");
        t tVar = t.f1093a;
        if (rootfsFile == null) {
            return tVar;
        }
        try {
            JSONObject jSONObjectOptJSONObject2 = new JSONObject(rootfsFile).optJSONObject("skills");
            if (jSONObjectOptJSONObject2 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("entries")) != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(next);
                    if (jSONObjectOptJSONObject3 != null && jSONObjectOptJSONObject3.has(ExtensionCallContract.ENABLED)) {
                        linkedHashMap.put(next, Boolean.valueOf(jSONObjectOptJSONObject3.optBoolean(ExtensionCallContract.ENABLED, true)));
                    }
                }
                return linkedHashMap;
            }
        } catch (Exception unused) {
        }
        return tVar;
    }

    private final File managedSkillDirOnDisk(String skillId) {
        return this.rootfs.resolveRootfsPath(this.managedBase + "/" + skillId);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String mergeSkillMetaAfterUpdate(java.lang.String r11, java.lang.String r12, android.content.ContentValues r13, android.os.Bundle r14, java.lang.String r15, java.lang.String r16, java.lang.String r17) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.provider.handlers.SkillsHandler.mergeSkillMetaAfterUpdate(java.lang.String, java.lang.String, android.content.ContentValues, android.os.Bundle, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    private final Bundle ok(String skillId) {
        return OperationResult.INSTANCE.success(skillId);
    }

    private final String readInstallVersionFromSkillMd(String skillId) {
        String string;
        String rootfsFile = this.rootfs.readRootfsFile(this.managedBase + "/" + skillId + "/SKILL.md");
        if (rootfsFile == null) {
            return null;
        }
        Companion companion = INSTANCE;
        String version = companion.parseSkillMdFrontmatter$step_runtime_release(companion.normalizeSkillMd$step_runtime_release(rootfsFile)).getVersion();
        if (version == null || (string = n.T1(version).toString()) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    private final String readMergedMetaVersion(String skillPath) {
        return InstallVersionResolver.INSTANCE.firstMetaVersionFromMerged(MetaJsonMerge.INSTANCE.mergeAllTopLevelJsonFiles(this.context, this.rootfs, skillPath));
    }

    private final String readMetaCatalogDescription(String skillPath) {
        String strOptString = MetaJsonMerge.INSTANCE.mergeAllTopLevelJsonFiles(this.context, this.rootfs, skillPath).optString(ExtensionCallContract.CATALOG_DESCRIPTION, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
        p.d(strOptString, "optString(...)");
        String string = n.T1(strOptString).toString();
        if (string.length() > 0) {
            return string;
        }
        return null;
    }

    private final String readSourceStorageKey(String skillPath, boolean isBuiltinDir) {
        JSONObject jSONObjectMergeAllTopLevelJsonFiles = MetaJsonMerge.INSTANCE.mergeAllTopLevelJsonFiles(this.context, this.rootfs, skillPath);
        if (jSONObjectMergeAllTopLevelJsonFiles.length() == 0) {
            return isBuiltinDir ? "bundled" : "local";
        }
        try {
            String strOptString = jSONObjectMergeAllTopLevelJsonFiles.optString(ExtensionCallContract.SOURCE, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
            p.d(strOptString, "optString(...)");
            String string = n.T1(strOptString).toString();
            if (n.t1(string)) {
                string = null;
            }
            return string == null ? isBuiltinDir ? "bundled" : "local" : string;
        } catch (Exception unused) {
            return isBuiltinDir ? "bundled" : "local";
        }
    }

    private final String requireContentValuesId(ContentValues values) {
        String string;
        String asString = values.getAsString("id");
        if (asString == null || (string = n.T1(asString).toString()) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    private final String requireContentValuesZipUri(ContentValues values) {
        String string;
        String asString = values.getAsString(ExtensionCallContract.ZIP_URI);
        if (asString == null || (string = n.T1(asString).toString()) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    private final String resolveId(Bundle extras) {
        return extras.getString("id");
    }

    private final int setEnableLocked(String skillId, boolean enable) throws JSONException {
        JSONObject jSONObject;
        ALog.i$default(TAG, "skill setEnable (persist): skillId=" + skillId + " enabled=" + enable, null, 4, null);
        String rootfsFile = this.rootfs.readRootfsFile("root/.openclaw/openclaw.json");
        if (rootfsFile == null) {
            rootfsFile = "{}";
        }
        try {
            jSONObject = new JSONObject(rootfsFile);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("skills");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            jSONObject.put("skills", jSONObjectOptJSONObject);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("entries");
        if (jSONObjectOptJSONObject2 == null) {
            jSONObjectOptJSONObject2 = new JSONObject();
            jSONObjectOptJSONObject.put("entries", jSONObjectOptJSONObject2);
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(skillId);
        if (jSONObjectOptJSONObject3 == null) {
            jSONObjectOptJSONObject3 = new JSONObject();
            jSONObjectOptJSONObject2.put(skillId, jSONObjectOptJSONObject3);
        }
        jSONObjectOptJSONObject3.put(ExtensionCallContract.ENABLED, enable);
        IRootfsAccess iRootfsAccess = this.rootfs;
        String string = jSONObject.toString(2);
        p.d(string, "toString(...)");
        iRootfsAccess.writeRootfsFile("root/.openclaw/openclaw.json", string);
        return 1;
    }

    private final Bundle setEnableOperation(Bundle extras) {
        Object objO;
        String strResolveId = resolveId(extras);
        if (strResolveId == null) {
            ALog.w$default(TAG, "skill setEnable (call): MISSING_ID keys=" + extras.keySet(), null, 4, null);
            return err("MISSING_ID", "id required");
        }
        if (!extras.containsKey(ExtensionCallContract.ENABLED)) {
            ALog.w$default(TAG, "skill setEnable (call): MISSING_ENABLED skillId=".concat(strResolveId), null, 4, null);
            return err("MISSING_ENABLED", "enabled required");
        }
        boolean z = extras.getBoolean(ExtensionCallContract.ENABLED);
        ALog.i$default(TAG, "skill setEnable (call): skillId=" + strResolveId + " enabled=" + z, null, 4, null);
        try {
            objO = setEnable(strResolveId, z) > 0 ? ok(strResolveId) : err("SET_ENABLE_FAILED", "setEnable returned 0");
        } catch (Throwable th) {
            objO = a.o(th);
        }
        Throwable thA = b5.i.a(objO);
        if (thA != null) {
            ALog.e(TAG, "skill setEnable (call) failed: skillId=" + strResolveId + " enabled=" + z, thA);
            String message = thA.getMessage();
            if (message == null) {
                message = thA.getClass().getSimpleName();
            }
            objO = err("SET_ENABLE_FAILED", message);
        }
        return (Bundle) objO;
    }

    private final boolean skillRootHasAnyFile(File dir) {
        if (!dir.exists() || !dir.isDirectory()) {
            return false;
        }
        m5.h hVar = new m5.h(new m5.j(dir, k.f3923a, null));
        while (hVar.hasNext()) {
            if (((File) hVar.next()).isFile()) {
                return true;
            }
        }
        return false;
    }

    private final Bundle uninstallOperation(Bundle extras) {
        String strResolveId = resolveId(extras);
        if (strResolveId == null) {
            ALog.w$default(TAG, "skill uninstall (call): MISSING_ID keys=" + extras.keySet(), null, 4, null);
            return err("MISSING_ID", "id required");
        }
        ALog.i$default(TAG, "skill uninstall (call): skillId=".concat(strResolveId), null, 4, null);
        if (delete(strResolveId) > 0) {
            return ok(strResolveId);
        }
        ALog.w$default(TAG, "skill uninstall (call): not found skillId=".concat(strResolveId), null, 4, null);
        return err("NOT_FOUND", "skill not found or not removable: ".concat(strResolveId));
    }

    public static /* synthetic */ int update$default(SkillsHandler skillsHandler, String str, ContentValues contentValues, Bundle bundle, String str2, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            bundle = null;
        }
        if ((i8 & 8) != 0) {
            str2 = null;
        }
        return skillsHandler.update(str, contentValues, bundle, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0133  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.os.Bundle updateOperation(android.os.Bundle r19) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.provider.handlers.SkillsHandler.updateOperation(android.os.Bundle):android.os.Bundle");
    }

    private final void writeSkillMeta(String skillId, String source, String businessVersion, Bundle extras, String catalogDescription) throws JSONException {
        String strO = b.o(this.managedBase, "/", skillId);
        String strN = b.n(strO, "/.skill-meta.json");
        JSONObject jSONObjectMergeAllTopLevelJsonFiles = MetaJsonMerge.INSTANCE.mergeAllTopLevelJsonFiles(this.context, this.rootfs, strO);
        InstallVersionResolver installVersionResolver = InstallVersionResolver.INSTANCE;
        JSONObject jSONObject = installVersionResolver.parseJSONObject(this.rootfs.readRootfsFile(strN));
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put(ExtensionCallContract.SOURCE, source);
        String strResolve = installVersionResolver.resolve(businessVersion, jSONObjectMergeAllTopLevelJsonFiles, readInstallVersionFromSkillMd(skillId));
        jSONObject.remove("install_version");
        jSONObject.put("version", strResolve);
        if (catalogDescription != null && !n.t1(catalogDescription)) {
            jSONObject.put(ExtensionCallContract.CATALOG_DESCRIPTION, n.T1(catalogDescription).toString());
        }
        JSONObject jSONObjectBundleToJsonObject = ExtensionBundleJsonKt.bundleToJsonObject(extras);
        if (jSONObjectBundleToJsonObject != null && jSONObjectBundleToJsonObject.length() > 0) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("extension");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            Iterator<String> itKeys = jSONObjectBundleToJsonObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObjectOptJSONObject.put(next, jSONObjectBundleToJsonObject.get(next));
            }
            jSONObject.put("extension", jSONObjectOptJSONObject);
        }
        IRootfsAccess iRootfsAccess = this.rootfs;
        String string = jSONObject.toString(2);
        p.d(string, "toString(...)");
        iRootfsAccess.writeRootfsFile(strN, string);
    }

    public static /* synthetic */ void writeSkillMeta$default(SkillsHandler skillsHandler, String str, String str2, String str3, Bundle bundle, String str4, int i8, Object obj) throws JSONException {
        if ((i8 & 8) != 0) {
            bundle = null;
        }
        if ((i8 & 16) != 0) {
            str4 = null;
        }
        skillsHandler.writeSkillMeta(str, str2, str3, bundle, str4);
    }

    public final int delete(String skillId) {
        int i8;
        p.e(skillId, "skillId");
        synchronized (this.fsLock) {
            try {
                ALog.i$default(TAG, "skill uninstall: skillId=".concat(skillId), null, 4, null);
                File fileManagedSkillDirOnDisk = managedSkillDirOnDisk(skillId);
                if (!fileManagedSkillDirOnDisk.exists()) {
                    fileManagedSkillDirOnDisk = this.rootfs.resolveRootfsPath(this.builtinBase + "/" + skillId);
                }
                if (fileManagedSkillDirOnDisk.exists()) {
                    m5.l.z0(fileManagedSkillDirOnDisk);
                    i8 = 1;
                } else {
                    i8 = 0;
                }
                if (i8 > 0) {
                    ALog.i$default(TAG, "skill uninstall success: skillId=" + skillId + " removed path=" + fileManagedSkillDirOnDisk.getAbsolutePath(), null, 4, null);
                } else {
                    ALog.w$default(TAG, "skill uninstall: not found skillId=".concat(skillId), null, 4, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00dd  */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.net.Uri install(android.content.ContentValues r18, android.os.Bundle r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.provider.handlers.SkillsHandler.install(android.content.ContentValues, android.os.Bundle, java.lang.String):android.net.Uri");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public final Bundle operation(Bundle extras) {
        p.e(extras, "extras");
        String string = extras.getString(ExtensionCallContract.OP);
        if (string == null) {
            return err("MISSING_OP", "op required");
        }
        switch (string.hashCode()) {
            case -838846263:
                if (string.equals(ExtensionCallContract.OP_UPDATE)) {
                    return updateOperation(extras);
                }
                break;
            case -625596190:
                if (string.equals(ExtensionCallContract.OP_UNINSTALL)) {
                    return uninstallOperation(extras);
                }
                break;
            case 182549637:
                if (string.equals(ExtensionCallContract.OP_SET_ENABLE)) {
                    return setEnableOperation(extras);
                }
                break;
            case 1957569947:
                if (string.equals(ExtensionCallContract.OP_INSTALL)) {
                    return installOperation(extras);
                }
                break;
        }
        return err("UNKNOWN_OP", "unknown op=".concat(string));
    }

    public final Cursor query() {
        MatrixCursor matrixCursor;
        synchronized (this.fsLock) {
            Map<String, Boolean> mapLoadSkillEnabledMap = loadSkillEnabledMap();
            matrixCursor = new MatrixCursor(new String[]{"id", "name", "path", "has_skill_md", "version", "description", ExtensionCallContract.CATALOG_DESCRIPTION, ExtensionCallContract.SOURCE, "tags", "is_enabled", "modified_at_ms"});
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            listSkillsFromDir(this.managedBase, matrixCursor, linkedHashSet, false, mapLoadSkillEnabledMap);
            listSkillsFromDir(this.builtinBase, matrixCursor, linkedHashSet, true, mapLoadSkillEnabledMap);
        }
        return matrixCursor;
    }

    public final int setEnable(String skillId, boolean enable) {
        int enableLocked;
        p.e(skillId, "skillId");
        synchronized (this.fsLock) {
            enableLocked = setEnableLocked(skillId, enable);
        }
        return enableLocked;
    }

    public final int update(String skillId, ContentValues values, Bundle metaExtras, String catalogDescription) {
        String str;
        p.e(skillId, "skillId");
        p.e(values, "values");
        synchronized (this.fsLock) {
            String strRequireContentValuesZipUri = requireContentValuesZipUri(values);
            if (strRequireContentValuesZipUri == null) {
                ALog.w$default(TAG, "skill update: missing zip_uri skillId=" + skillId + " keys=" + values.keySet(), null, 4, null);
                return 0;
            }
            ALog.i$default(TAG, "skill update: skillId=" + skillId + " zipUri=" + strRequireContentValuesZipUri + " keys=" + values.keySet(), null, 4, null);
            Uri uri = Uri.parse(strRequireContentValuesZipUri);
            try {
                String str2 = managedSkillDirOnDisk(skillId).exists() ? this.managedBase : this.builtinBase;
                String rootfsFile = this.rootfs.readRootfsFile(this.managedBase + "/" + skillId + "/.skill-meta.json");
                if (rootfsFile == null) {
                    rootfsFile = this.rootfs.readRootfsFile(str2 + "/" + skillId + "/.skill-meta.json");
                }
                str = rootfsFile;
                ZipExtractor zipExtractor = ZipExtractor.INSTANCE;
                zipExtractor.deleteDir(this.context, this.rootfs, str2, skillId);
                this.rootfs.ensureDirectory(this.managedBase);
                Context context = this.context;
                IRootfsAccess iRootfsAccess = this.rootfs;
                String str3 = this.managedBase;
                p.b(uri);
                zipExtractor.extract(context, iRootfsAccess, str3, skillId, uri);
                try {
                    File fileManagedSkillDirOnDisk = managedSkillDirOnDisk(skillId);
                    try {
                        if (!skillRootHasAnyFile(fileManagedSkillDirOnDisk)) {
                            str = skillId;
                            try {
                                m5.l.z0(fileManagedSkillDirOnDisk);
                            } catch (Throwable th) {
                                a.o(th);
                            }
                            throw new IllegalStateException("Skill update produced no files on disk (skillId=" + str + ").");
                        }
                        String strMergeSkillMetaAfterUpdate = mergeSkillMetaAfterUpdate(str, this.rootfs.readRootfsFile(this.managedBase + "/" + skillId + "/.skill-meta.json"), values, metaExtras, catalogDescription, readInstallVersionFromSkillMd(skillId), this.managedBase + "/" + skillId);
                        this.rootfs.writeRootfsFile(this.managedBase + "/" + skillId + "/.skill-meta.json", strMergeSkillMetaAfterUpdate);
                        ALog.i$default(TAG, "skill update success: skillId=" + skillId + " disk=" + fileManagedSkillDirOnDisk.getAbsolutePath(), null, 4, null);
                        return 1;
                    } catch (Throwable th2) {
                        th = th2;
                        ALog.e(TAG, "skill update failed: skillId=" + str + " zipUri=" + strRequireContentValuesZipUri, th);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str = skillId;
                }
            } catch (Throwable th4) {
                th = th4;
                str = skillId;
            }
        }
    }
}
