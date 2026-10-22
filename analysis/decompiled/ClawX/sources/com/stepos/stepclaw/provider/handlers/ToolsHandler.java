package com.stepos.stepclaw.provider.handlers;

import a.a;
import a8.b;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import b5.g;
import c5.m;
import c5.n;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.provider.backend.IRootfsAccess;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import com.stepos.stepclaw.provider.contract.ExtensionCallContractKt;
import com.stepos.stepclaw.provider.contract.OperationResult;
import com.stepos.stepclaw.provider.handlers.SkillsHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import m5.h;
import m5.j;
import m5.k;
import m5.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b$\u0018\u0000 R2\u00020\u0001:\u0001RB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060!H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u0004\u0018\u00010\u00062\u0006\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010+J5\u00100\u001a\u00020/2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b0\u00101J\u0019\u00102\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b2\u0010+JG\u00107\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u00010\u00062\b\u00104\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u00105\u001a\u0004\u0018\u00010\u00062\u0006\u00106\u001a\u00020\u0006H\u0002¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b9\u0010\u0010J\u0019\u0010:\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b<\u0010\u0010J\u0017\u0010=\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b=\u0010\u0010J\u0017\u0010>\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b>\u0010\u0010J\u0019\u0010?\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b?\u0010@J\u001f\u0010C\u001a\u00020\r2\u0006\u0010A\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u0006H\u0002¢\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\u00122\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\bG\u0010HJ\u0019\u0010I\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\bI\u0010JJ\u0019\u0010K\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\bK\u0010JR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010LR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010MR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010NR\u0014\u0010O\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\bQ\u0010N¨\u0006S"}, d2 = {"Lcom/stepos/stepclaw/provider/handlers/ToolsHandler;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Landroid/content/Context;", "context", "Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;", "rootfs", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "authority", "<init>", "(Landroid/content/Context;Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;Ljava/lang/String;)V", "Landroid/database/Cursor;", "query", "()Landroid/database/Cursor;", "Landroid/os/Bundle;", ExtensionCallContract.KEY_EXTRAS, "operation", "(Landroid/os/Bundle;)Landroid/os/Bundle;", "toolId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "enable", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ExtensionCallContract.OP_SET_ENABLE, "(Ljava/lang/String;Z)I", "Landroid/content/ContentValues;", "values", "Landroid/net/Uri;", ExtensionCallContract.OP_INSTALL, "(Landroid/content/ContentValues;Landroid/os/Bundle;)Landroid/net/Uri;", "metaExtras", ExtensionCallContract.OP_UPDATE, "(Ljava/lang/String;Landroid/content/ContentValues;Landroid/os/Bundle;)I", "delete", "(Ljava/lang/String;)I", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "readToolsDenyIds", "()Ljava/util/Set;", "Ljava/io/File;", "dir", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "dirLastModified", "(Ljava/io/File;)J", "toolPath", "readMergedMetaVersion", "(Ljava/lang/String;)Ljava/lang/String;", "readSourceStorageKey", ExtensionCallContract.SOURCE, "businessVersion", "Lb5/a0;", "writeToolMeta", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "readInstallVersionFromToolPackage", "oldMetaRaw", "packagedMetaAfterExtract", "markdownFallbackVersion", "toolDirForMergedJson", "mergeToolMetaAfterUpdate", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "installOperation", "resolveId", "(Landroid/os/Bundle;)Ljava/lang/String;", "updateOperation", "uninstallOperation", "setEnableOperation", ConfigIpcContract.KEY_OK, "(Ljava/lang/String;)Landroid/os/Bundle;", "code", "msg", "err", "(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;", "toolDirOnDisk", "(Ljava/lang/String;)Ljava/io/File;", "toolRootHasAnyFile", "(Ljava/io/File;)Z", "requireContentValuesId", "(Landroid/content/ContentValues;)Ljava/lang/String;", "requireContentValuesZipUri", "Landroid/content/Context;", "Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;", "Ljava/lang/String;", "fsLock", "Ljava/lang/Object;", "base", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ToolsHandler {
    private static final String TAG = "ToolsHandler";
    private final String authority;
    private final String base;
    private final Context context;
    private final Object fsLock;
    private final IRootfsAccess rootfs;
    private static final Companion Companion = new Companion(null);
    private static final List<g> CORE_TOOLS = n.k0(new g("read", "Read file contents"), new g("write", "Create or overwrite files"), new g("edit", "Make precise edits to files"), new g("apply_patch", "Apply multi-file patches"), new g("grep", "Search file contents for patterns"), new g("find", "Find files by glob pattern"), new g("ls", "List directory contents"), new g("exec", "Run shell commands (pty available for TTY-required CLIs)"), new g("process", "Manage background exec sessions"), new g("web_search", "Search the web (provider from config)"), new g("web_fetch", "Fetch and extract readable content from a URL"), new g("browser", "Launch and control a local Chromium-based browser (PC/desktop only)"), new g("canvas", "Present/eval/snapshot the Canvas"), new g("nodes", "Invoke phone capabilities (ability.call via invokeParamsJson)"), new g("cron", "OpenClaw cron and wake jobs. Reminders/scheduled tasks here; calendar events use android-abilities, not this tool."), new g(OperationResult.EXTRA_MESSAGE, "Send messages and channel actions"), new g("gateway", "Restart, apply config, or run updates on the running OpenClaw process"), new g("agents_list", "List OpenClaw agent ids allowed for sessions_spawn"), new g("sessions_list", "List other sessions (incl. sub-agents) with filters/last"), new g("sessions_history", "Fetch history for another session/sub-agent"), new g("sessions_send", "Send a message to another session/sub-agent"), new g("sessions_spawn", "Spawn an isolated sub-agent or ACP coding session"), new g("subagents", "List, steer, or kill sub-agent runs for this requester session"), new g("session_status", "Show usage/time/model state (📊 session_status)"), new g("image", "Analyze an image with the configured image model"));

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R)\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/stepclaw/provider/handlers/ToolsHandler$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lb5/g;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "CORE_TOOLS", "Ljava/util/List;", "getCORE_TOOLS", "()Ljava/util/List;", "TAG", "Ljava/lang/String;", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final List<g> getCORE_TOOLS() {
            return ToolsHandler.CORE_TOOLS;
        }

        private Companion() {
        }
    }

    public ToolsHandler(Context context, IRootfsAccess rootfs, String authority) {
        p.e(context, "context");
        p.e(rootfs, "rootfs");
        p.e(authority, "authority");
        this.context = context;
        this.rootfs = rootfs;
        this.authority = authority;
        this.fsLock = new Object();
        this.base = "usr/local/lib/node_modules/openclaw/tools";
    }

    private final long dirLastModified(File dir) {
        if (!dir.exists() || !dir.isDirectory()) {
            return 0L;
        }
        Long l3 = null;
        h hVar = new h(new j(dir, k.f3923a, null));
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

    public static /* synthetic */ Uri install$default(ToolsHandler toolsHandler, ContentValues contentValues, Bundle bundle, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            bundle = null;
        }
        return toolsHandler.install(contentValues, bundle);
    }

    private final Bundle installOperation(Bundle extras) {
        Object objO;
        String strResolveExtensionToolId = ExtensionCallContractKt.resolveExtensionToolId(extras);
        if (strResolveExtensionToolId == null) {
            ALog.w$default(TAG, "tool install (call): MISSING_ID keys=" + extras.keySet(), null, 4, null);
            return err("MISSING_ID", "id required");
        }
        String strResolveExtensionZipUri = ExtensionCallContractKt.resolveExtensionZipUri(extras);
        if (strResolveExtensionZipUri == null) {
            ALog.w$default(TAG, "tool install (call): MISSING_ZIP_URI toolId=" + strResolveExtensionToolId + " keys=" + extras.keySet(), null, 4, null);
            return err("MISSING_ZIP_URI", "zip_uri required");
        }
        String string = extras.getString(ExtensionCallContract.SOURCE);
        if (string == null) {
            string = "local";
        }
        String string2 = extras.getString("version");
        String str = string2 == null ? AbstractJsonLexerKt.NULL : string2;
        StringBuilder sbV = b.v("tool install (call): op=install toolId=", strResolveExtensionToolId, " source=", string, " version=");
        sbV.append(str);
        sbV.append(" zipUri=");
        sbV.append(strResolveExtensionZipUri);
        ALog.i$default(TAG, sbV.toString(), null, 4, null);
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", strResolveExtensionToolId);
        contentValues.put(ExtensionCallContract.ZIP_URI, strResolveExtensionZipUri);
        contentValues.put(ExtensionCallContract.SOURCE, string);
        if (string2 != null && !x5.n.t1(string2)) {
            contentValues.put("version", string2);
        }
        try {
            install(contentValues, extras.getBundle(ExtensionCallContract.KEY_EXTRAS));
            objO = ok(strResolveExtensionToolId);
        } catch (Throwable th) {
            objO = a.o(th);
        }
        Throwable thA = b5.i.a(objO);
        if (thA != null) {
            ALog.e(TAG, b.p("tool install (call) failed: toolId=", strResolveExtensionToolId, " zipUri=", strResolveExtensionZipUri), thA);
            String message = thA.getMessage();
            if (message == null) {
                message = thA.getClass().getSimpleName();
            }
            objO = err("INSTALL_FAILED", message);
        }
        return (Bundle) objO;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String mergeToolMetaAfterUpdate(java.lang.String r7, java.lang.String r8, android.content.ContentValues r9, android.os.Bundle r10, java.lang.String r11, java.lang.String r12) throws org.json.JSONException {
        /*
            r6 = this;
            java.lang.String r0 = "version"
            java.lang.String r1 = r9.getAsString(r0)
            r2 = 0
            if (r1 == 0) goto L1a
            java.lang.CharSequence r1 = x5.n.T1(r1)
            java.lang.String r1 = r1.toString()
            if (r1 == 0) goto L1a
            int r3 = r1.length()
            if (r3 <= 0) goto L1a
            goto L1b
        L1a:
            r1 = r2
        L1b:
            java.lang.String r3 = "source"
            java.lang.String r9 = r9.getAsString(r3)
            if (r9 == 0) goto L34
            java.lang.CharSequence r9 = x5.n.T1(r9)
            java.lang.String r9 = r9.toString()
            if (r9 == 0) goto L34
            int r4 = r9.length()
            if (r4 <= 0) goto L34
            goto L35
        L34:
            r9 = r2
        L35:
            if (r10 == 0) goto L48
            java.util.Set r4 = r10.keySet()
            java.lang.String r5 = "keySet(...)"
            kotlin.jvm.internal.p.d(r4, r5)
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L48
            r4 = 1
            goto L49
        L48:
            r4 = 0
        L49:
            if (r8 == 0) goto L5e
            boolean r5 = x5.n.t1(r8)     // Catch: java.lang.Exception -> L5e
            if (r5 == 0) goto L52
            goto L5e
        L52:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Exception -> L5e
            r5.<init>(r8)     // Catch: java.lang.Exception -> L5e
            int r8 = r5.length()     // Catch: java.lang.Exception -> L5e
            if (r8 <= 0) goto L5e
            goto L5f
        L5e:
            r5 = r2
        L5f:
            if (r7 == 0) goto L74
            boolean r8 = x5.n.t1(r7)     // Catch: java.lang.Exception -> L74
            if (r8 == 0) goto L68
            goto L74
        L68:
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch: java.lang.Exception -> L74
            r8.<init>(r7)     // Catch: java.lang.Exception -> L74
            int r7 = r8.length()     // Catch: java.lang.Exception -> L74
            if (r7 <= 0) goto L74
            r2 = r8
        L74:
            if (r5 != 0) goto L7f
            if (r2 != 0) goto L7e
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            goto L7f
        L7e:
            r5 = r2
        L7f:
            com.stepos.stepclaw.provider.handlers.MetaJsonMerge r7 = com.stepos.stepclaw.provider.handlers.MetaJsonMerge.INSTANCE
            android.content.Context r8 = r6.context
            com.stepos.stepclaw.provider.backend.IRootfsAccess r6 = r6.rootfs
            org.json.JSONObject r6 = r7.mergeAllTopLevelJsonFiles(r8, r6, r12)
            com.stepos.stepclaw.provider.handlers.InstallVersionResolver r7 = com.stepos.stepclaw.provider.handlers.InstallVersionResolver.INSTANCE
            java.lang.String r6 = r7.resolve(r1, r6, r11)
            if (r9 == 0) goto L94
            r5.put(r3, r9)
        L94:
            java.lang.String r7 = "install_version"
            r5.remove(r7)
            r5.put(r0, r6)
            if (r4 == 0) goto Ld7
            org.json.JSONObject r6 = com.stepos.stepclaw.provider.handlers.ExtensionBundleJsonKt.bundleToJsonObject(r10)
            if (r6 != 0) goto La9
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
        La9:
            int r7 = r6.length()
            if (r7 <= 0) goto Ld7
            java.lang.String r7 = "extension"
            org.json.JSONObject r8 = r5.optJSONObject(r7)
            if (r8 != 0) goto Lbc
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
        Lbc:
            java.util.Iterator r9 = r6.keys()
        Lc0:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto Ld4
            java.lang.Object r10 = r9.next()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r6.get(r10)
            r8.put(r10, r11)
            goto Lc0
        Ld4:
            r5.put(r7, r8)
        Ld7:
            r6 = 2
            java.lang.String r6 = r5.toString(r6)
            java.lang.String r7 = "toString(...)"
            kotlin.jvm.internal.p.d(r6, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.provider.handlers.ToolsHandler.mergeToolMetaAfterUpdate(java.lang.String, java.lang.String, android.content.ContentValues, android.os.Bundle, java.lang.String, java.lang.String):java.lang.String");
    }

    private final Bundle ok(String toolId) {
        return OperationResult.INSTANCE.success(toolId);
    }

    private final String readInstallVersionFromToolPackage(String toolId) {
        String str;
        String string;
        String strO = b.o(this.base, "/", toolId);
        Iterator it = n.k0("TOOL.md", "tool.md", "SKILL.md", "skill.md", "README.md").iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            String rootfsFile = this.rootfs.readRootfsFile(strO + "/" + str2);
            if (rootfsFile != null) {
                SkillsHandler.Companion companion = SkillsHandler.INSTANCE;
                String version = companion.parseSkillMdFrontmatter$step_runtime_release(companion.normalizeSkillMd$step_runtime_release(rootfsFile)).getVersion();
                if (version != null && (string = x5.n.T1(version).toString()) != null) {
                    str = string.length() > 0 ? string : null;
                    if (str != null) {
                        break;
                    }
                }
            }
        }
        return str;
    }

    private final String readMergedMetaVersion(String toolPath) {
        return InstallVersionResolver.INSTANCE.firstMetaVersionFromMerged(MetaJsonMerge.INSTANCE.mergeAllTopLevelJsonFiles(this.context, this.rootfs, toolPath));
    }

    private final String readSourceStorageKey(String toolPath) {
        JSONObject jSONObjectMergeAllTopLevelJsonFiles = MetaJsonMerge.INSTANCE.mergeAllTopLevelJsonFiles(this.context, this.rootfs, toolPath);
        if (jSONObjectMergeAllTopLevelJsonFiles.length() == 0) {
            return "unknown";
        }
        try {
            String strOptString = jSONObjectMergeAllTopLevelJsonFiles.optString(ExtensionCallContract.SOURCE, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
            p.d(strOptString, "optString(...)");
            String string = x5.n.T1(strOptString).toString();
            if (x5.n.t1(string)) {
                string = null;
            }
            return string == null ? "unknown" : string;
        } catch (Exception unused) {
            return "unknown";
        }
    }

    private final Set<String> readToolsDenyIds() {
        JSONArray jSONArrayOptJSONArray;
        String string;
        String rootfsFile = this.rootfs.readRootfsFile("root/.openclaw/openclaw.json");
        if (rootfsFile != null) {
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(rootfsFile).optJSONObject("tools");
                if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("deny")) != null) {
                    d5.j jVar = new d5.j(new d5.g());
                    d5.g gVar = jVar.f1850a;
                    int length = jSONArrayOptJSONArray.length();
                    for (int i8 = 0; i8 < length; i8++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i8);
                        if (strOptString != null && (string = x5.n.T1(strOptString).toString()) != null) {
                            if (string.length() <= 0 || u.c1(string, "group:", false)) {
                                string = null;
                            }
                            if (string != null) {
                                jVar.add(string);
                            }
                        }
                    }
                    gVar.b();
                    return gVar.f1841j > 0 ? jVar : d5.j.f1849b;
                }
            } catch (Exception unused) {
            }
        }
        return c5.u.f1094a;
    }

    private final String requireContentValuesId(ContentValues values) {
        String string;
        String asString = values.getAsString("id");
        if (asString == null || (string = x5.n.T1(asString).toString()) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    private final String requireContentValuesZipUri(ContentValues values) {
        String string;
        String asString = values.getAsString(ExtensionCallContract.ZIP_URI);
        if (asString == null || (string = x5.n.T1(asString).toString()) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    private final String resolveId(Bundle extras) {
        return extras.getString("id");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setEnable$lambda$0$3(String str, String it) {
        p.e(it, "it");
        return it.equals(str);
    }

    private final Bundle setEnableOperation(Bundle extras) {
        Object objO;
        String strResolveId = resolveId(extras);
        if (strResolveId == null) {
            ALog.w$default(TAG, "tool setEnable (call): MISSING_ID keys=" + extras.keySet(), null, 4, null);
            return err("MISSING_ID", "id required");
        }
        if (!extras.containsKey(ExtensionCallContract.ENABLED)) {
            ALog.w$default(TAG, "tool setEnable (call): MISSING_ENABLED toolId=".concat(strResolveId), null, 4, null);
            return err("MISSING_ENABLED", "enabled required");
        }
        boolean z = extras.getBoolean(ExtensionCallContract.ENABLED);
        ALog.i$default(TAG, "tool setEnable (call): toolId=" + strResolveId + " enabled=" + z, null, 4, null);
        try {
            objO = setEnable(strResolveId, z) > 0 ? ok(strResolveId) : err("SET_ENABLE_FAILED", "setEnable returned 0");
        } catch (Throwable th) {
            objO = a.o(th);
        }
        Throwable thA = b5.i.a(objO);
        if (thA != null) {
            ALog.e(TAG, "tool setEnable (call) failed: toolId=" + strResolveId + " enabled=" + z, thA);
            String message = thA.getMessage();
            if (message == null) {
                message = thA.getClass().getSimpleName();
            }
            objO = err("SET_ENABLE_FAILED", message);
        }
        return (Bundle) objO;
    }

    private final File toolDirOnDisk(String toolId) {
        return this.rootfs.resolveRootfsPath(this.base + "/" + toolId);
    }

    private final boolean toolRootHasAnyFile(File dir) {
        if (!dir.exists() || !dir.isDirectory()) {
            return false;
        }
        h hVar = new h(new j(dir, k.f3923a, null));
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
            ALog.w$default(TAG, "tool uninstall (call): MISSING_ID keys=" + extras.keySet(), null, 4, null);
            return err("MISSING_ID", "id required");
        }
        ALog.i$default(TAG, "tool uninstall (call): toolId=".concat(strResolveId), null, 4, null);
        if (delete(strResolveId) > 0) {
            return ok(strResolveId);
        }
        ALog.w$default(TAG, "tool uninstall (call): not found or core tool toolId=".concat(strResolveId), null, 4, null);
        return err("NOT_FOUND", "tool not found or not removable: ".concat(strResolveId));
    }

    public static /* synthetic */ int update$default(ToolsHandler toolsHandler, String str, ContentValues contentValues, Bundle bundle, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            bundle = null;
        }
        return toolsHandler.update(str, contentValues, bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.os.Bundle updateOperation(android.os.Bundle r18) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.provider.handlers.ToolsHandler.updateOperation(android.os.Bundle):android.os.Bundle");
    }

    private final void writeToolMeta(String toolId, String source, String businessVersion, Bundle extras) throws JSONException {
        JSONObject jSONObject;
        String strO = b.o(this.base, "/", toolId);
        String strN = b.n(strO, "/.tool-meta.json");
        JSONObject jSONObjectMergeAllTopLevelJsonFiles = MetaJsonMerge.INSTANCE.mergeAllTopLevelJsonFiles(this.context, this.rootfs, strO);
        String rootfsFile = this.rootfs.readRootfsFile(strN);
        if (rootfsFile != null) {
            try {
                jSONObject = x5.n.t1(rootfsFile) ? new JSONObject() : new JSONObject(rootfsFile);
            } catch (Exception unused) {
                jSONObject = new JSONObject();
            }
        }
        jSONObject.put(ExtensionCallContract.SOURCE, source);
        String strResolve = InstallVersionResolver.INSTANCE.resolve(businessVersion, jSONObjectMergeAllTopLevelJsonFiles, readInstallVersionFromToolPackage(toolId));
        jSONObject.remove("install_version");
        jSONObject.put("version", strResolve);
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

    public static /* synthetic */ void writeToolMeta$default(ToolsHandler toolsHandler, String str, String str2, String str3, Bundle bundle, int i8, Object obj) throws JSONException {
        if ((i8 & 8) != 0) {
            bundle = null;
        }
        toolsHandler.writeToolMeta(str, str2, str3, bundle);
    }

    public final int delete(String toolId) {
        p.e(toolId, "toolId");
        synchronized (this.fsLock) {
            try {
                ALog.i$default(TAG, "tool uninstall: toolId=".concat(toolId), null, 4, null);
                List<g> list = CORE_TOOLS;
                int i8 = 0;
                if (list == null || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (p.a(((g) it.next()).f892a, toolId)) {
                            ALog.w$default(TAG, "tool uninstall: blocked core tool toolId=" + toolId, null, 4, null);
                            return 0;
                        }
                    }
                }
                File file = toolDirOnDisk(toolId);
                if (file.exists()) {
                    l.z0(file);
                    i8 = 1;
                }
                if (i8 > 0) {
                    ALog.i$default(TAG, "tool uninstall success: toolId=" + toolId + " path=" + file.getAbsolutePath(), null, 4, null);
                } else {
                    ALog.w$default(TAG, "tool uninstall: not found toolId=" + toolId, null, 4, null);
                }
                return i8;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Uri install(ContentValues values, Bundle extras) {
        Set<String> setKeySet;
        String string;
        Uri uri;
        p.e(values, "values");
        synchronized (this.fsLock) {
            try {
                String strRequireContentValuesId = requireContentValuesId(values);
                if (strRequireContentValuesId == null) {
                    throw new IllegalArgumentException("id required");
                }
                String strRequireContentValuesZipUri = requireContentValuesZipUri(values);
                if (strRequireContentValuesZipUri == null) {
                    throw new IllegalArgumentException("zip_uri required");
                }
                String asString = values.getAsString(ExtensionCallContract.SOURCE);
                if (asString == null) {
                    asString = "local";
                }
                String asString2 = values.getAsString("version");
                String str = asString2 == null ? AbstractJsonLexerKt.NULL : asString2;
                Set<String> setKeySet2 = values.keySet();
                if (extras == null || (setKeySet = extras.keySet()) == null) {
                    setKeySet = c5.u.f1094a;
                }
                ALog.i$default(TAG, "tool install: toolId=" + strRequireContentValuesId + " source=" + asString + " version=" + str + " zipUri=" + strRequireContentValuesZipUri + " valuesKeys=" + setKeySet2 + " extrasKeys=" + setKeySet, null, 4, null);
                Uri uri2 = Uri.parse(strRequireContentValuesZipUri);
                try {
                    this.rootfs.ensureDirectory(this.base);
                    String str2 = asString;
                    ZipExtractor zipExtractor = ZipExtractor.INSTANCE;
                    Context context = this.context;
                    IRootfsAccess iRootfsAccess = this.rootfs;
                    String str3 = this.base;
                    p.b(uri2);
                    zipExtractor.extract(context, iRootfsAccess, str3, strRequireContentValuesId, uri2);
                    File file = toolDirOnDisk(strRequireContentValuesId);
                    if (!toolRootHasAnyFile(file)) {
                        try {
                            l.z0(file);
                        } catch (Throwable th) {
                            a.o(th);
                        }
                        throw new IllegalStateException("Tool install produced no files on disk (toolId=" + strRequireContentValuesId + "). Check ZIP layout and URI.");
                    }
                    if (asString2 == null || (string = x5.n.T1(asString2).toString()) == null || string.length() <= 0) {
                        string = null;
                    }
                    writeToolMeta(strRequireContentValuesId, str2, string, extras);
                    uri = Uri.parse("content://" + this.authority + "/tools/" + strRequireContentValuesId);
                    ALog.i$default(TAG, "tool install success: toolId=" + strRequireContentValuesId + " resultUri=" + uri + " disk=" + file.getAbsolutePath(), null, 4, null);
                } catch (Throwable th2) {
                    ALog.e(TAG, "tool install failed: toolId=" + strRequireContentValuesId + " zipUri=" + strRequireContentValuesZipUri, th2);
                    throw th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        p.d(uri, "synchronized(...)");
        return uri;
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
        File[] fileArrListFiles;
        synchronized (this.fsLock) {
            try {
                Set<String> toolsDenyIds = readToolsDenyIds();
                matrixCursor = new MatrixCursor(new String[]{"id", "name", "path", "version", ExtensionCallContract.KIND, "description", ExtensionCallContract.SOURCE, "tags", "is_enabled", "modified_at_ms"});
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (g gVar : CORE_TOOLS) {
                    String str = (String) gVar.f892a;
                    matrixCursor.addRow(new Object[]{str, str, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "core", (String) gVar.f893b, "bundled", "core|bundled", Integer.valueOf(!toolsDenyIds.contains(str) ? 1 : 0), 0L});
                    linkedHashSet.add(str);
                }
                File fileResolveRootfsPath = this.rootfs.resolveRootfsPath(this.base);
                if (fileResolveRootfsPath.exists() && (fileArrListFiles = fileResolveRootfsPath.listFiles()) != null) {
                    ArrayList arrayList = new ArrayList();
                    for (File file : fileArrListFiles) {
                        if (file.isDirectory()) {
                            arrayList.add(file);
                        }
                    }
                    for (File file2 : m.J0(arrayList, new Comparator() { // from class: com.stepos.stepclaw.provider.handlers.ToolsHandler$query$lambda$0$$inlined$sortedBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t8, T t9) {
                            return a.l(((File) t8).getName(), ((File) t9).getName());
                        }
                    })) {
                        String name = file2.getName();
                        if (!linkedHashSet.contains(name)) {
                            String str2 = this.base + "/" + name;
                            String mergedMetaVersion = readMergedMetaVersion(str2);
                            String sourceStorageKey = readSourceStorageKey(str2);
                            String strA0 = m.A0(m.N0(m.Q0(c5.l.S(new String[]{"installed", sourceStorageKey}))), "|", null, null, null, 62);
                            long jDirLastModified = dirLastModified(file2);
                            int i8 = !toolsDenyIds.contains(name) ? 1 : 0;
                            if (mergedMetaVersion == null) {
                                mergedMetaVersion = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                            }
                            matrixCursor.addRow(new Object[]{name, name, str2, mergedMetaVersion, "installed", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, sourceStorageKey, strA0, Integer.valueOf(i8), Long.valueOf(jDirLastModified)});
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return matrixCursor;
    }

    public final int setEnable(String toolId, boolean enable) {
        JSONObject jSONObject;
        String string;
        p.e(toolId, "toolId");
        synchronized (this.fsLock) {
            String rootfsFile = this.rootfs.readRootfsFile("root/.openclaw/openclaw.json");
            if (rootfsFile == null) {
                rootfsFile = "{}";
            }
            try {
                jSONObject = new JSONObject(rootfsFile);
            } catch (Exception unused) {
                jSONObject = new JSONObject();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("tools");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
                jSONObject.put("tools", jSONObjectOptJSONObject);
            }
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("deny");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArrayOptJSONArray.length();
            int i8 = 0;
            int i9 = 0;
            while (true) {
                if (i9 >= length) {
                    break;
                }
                String strOptString = jSONArrayOptJSONArray.optString(i9);
                if (strOptString != null && (string = x5.n.T1(strOptString).toString()) != null) {
                    String str = string.length() > 0 ? string : null;
                    if (str != null) {
                        arrayList.add(str);
                    }
                }
                i9++;
            }
            if (enable) {
                m.G0(arrayList, new c5.a(4, toolId));
            } else if (!arrayList.contains(toolId)) {
                arrayList.add(toolId);
            }
            JSONArray jSONArray = new JSONArray();
            int size = arrayList.size();
            while (i8 < size) {
                Object obj = arrayList.get(i8);
                i8++;
                jSONArray.put((String) obj);
            }
            jSONObjectOptJSONObject.put("deny", jSONArray);
            IRootfsAccess iRootfsAccess = this.rootfs;
            String string2 = jSONObject.toString(2);
            p.d(string2, "toString(...)");
            iRootfsAccess.writeRootfsFile("root/.openclaw/openclaw.json", string2);
            ALog.i$default(TAG, "tool setEnable (persist): toolId=" + toolId + " enabled=" + enable, null, 4, null);
        }
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.content.ContentValues, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.String] */
    public final int update(String toolId, ContentValues values, Bundle metaExtras) {
        String values2 = values;
        p.e(toolId, "toolId");
        p.e(values2, "values");
        synchronized (this.fsLock) {
            String strRequireContentValuesZipUri = requireContentValuesZipUri(values2);
            if (strRequireContentValuesZipUri == null) {
                ALog.w$default(TAG, "tool update: missing zip_uri toolId=" + toolId + " keys=" + values2.keySet(), null, 4, null);
                return 0;
            }
            ALog.i$default(TAG, "tool update: toolId=" + toolId + " zipUri=" + strRequireContentValuesZipUri + " keys=" + values2.keySet(), null, 4, null);
            Uri uri = Uri.parse(strRequireContentValuesZipUri);
            try {
                String rootfsFile = this.rootfs.readRootfsFile(this.base + "/" + toolId + "/.tool-meta.json");
                ZipExtractor zipExtractor = ZipExtractor.INSTANCE;
                zipExtractor.deleteDir(this.context, this.rootfs, this.base, toolId);
                this.rootfs.ensureDirectory(this.base);
                Context context = this.context;
                IRootfsAccess iRootfsAccess = this.rootfs;
                String str = this.base;
                p.b(uri);
                zipExtractor.extract(context, iRootfsAccess, str, toolId, uri);
                try {
                    File file = toolDirOnDisk(toolId);
                    try {
                        if (!toolRootHasAnyFile(file)) {
                            values2 = toolId;
                            try {
                                l.z0(file);
                            } catch (Throwable th) {
                                a.o(th);
                            }
                            throw new IllegalStateException("Tool update produced no files on disk (toolId=" + ((String) values2) + ").");
                        }
                        String strMergeToolMetaAfterUpdate = mergeToolMetaAfterUpdate(rootfsFile, this.rootfs.readRootfsFile(this.base + "/" + toolId + "/.tool-meta.json"), values2, metaExtras, readInstallVersionFromToolPackage(toolId), this.base + "/" + toolId);
                        this.rootfs.writeRootfsFile(this.base + "/" + toolId + "/.tool-meta.json", strMergeToolMetaAfterUpdate);
                        ALog.i$default(TAG, "tool update success: toolId=" + toolId + " disk=" + file.getAbsolutePath(), null, 4, null);
                        return 1;
                    } catch (Throwable th2) {
                        th = th2;
                        ALog.e(TAG, "tool update failed: toolId=" + values2 + " zipUri=" + strRequireContentValuesZipUri, th);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    values2 = toolId;
                }
            } catch (Throwable th4) {
                th = th4;
                values2 = toolId;
            }
        }
    }
}
