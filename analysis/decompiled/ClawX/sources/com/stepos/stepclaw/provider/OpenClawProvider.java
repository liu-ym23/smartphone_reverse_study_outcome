package com.stepos.stepclaw.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Process;
import c5.m;
import c5.n;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.config.DeviceGatewayTokenStore;
import com.stepos.stepclaw.config.GatewayAuthConstants;
import com.stepos.stepclaw.provider.backend.OpenClawProviderBackend;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import com.stepos.stepclaw.provider.handlers.ChannelsHandler;
import com.stepos.stepclaw.provider.handlers.ConfigModelHandler;
import com.stepos.stepclaw.provider.handlers.CoreFilesHandler;
import com.stepos.stepclaw.provider.handlers.CronRunLogsHandler;
import com.stepos.stepclaw.provider.handlers.CronjobsHandler;
import com.stepos.stepclaw.provider.handlers.GatewayManagerHandler;
import com.stepos.stepclaw.provider.handlers.SkillsHandler;
import com.stepos.stepclaw.provider.handlers.ToolsHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 O2\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u000eJ\u000f\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0011H\u0016¢\u0006\u0004\b!\u0010\"JQ\u0010(\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0010\u0010$\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010\f2\u0010\u0010&\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010#2\b\u0010'\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b(\u0010)J#\u0010*\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b*\u0010+J=\u0010,\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010%\u001a\u0004\u0018\u00010\f2\u0010\u0010&\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010#H\u0016¢\u0006\u0004\b,\u0010-J3\u0010.\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\f2\u0010\u0010&\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010#H\u0016¢\u0006\u0004\b.\u0010/J\u0019\u00100\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b0\u0010\u000eJ-\u00105\u001a\u0004\u0018\u0001032\u0006\u00101\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010\f2\b\u00104\u001a\u0004\u0018\u000103H\u0016¢\u0006\u0004\b5\u00106R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010;\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010A\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006P"}, d2 = {"Lcom/stepos/stepclaw/provider/OpenClawProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "Lb5/a0;", "initHandlersIfNeeded", "ensureHandlers", "Landroid/database/Cursor;", "queryGatewayAuthToken", "()Landroid/database/Cursor;", "Landroid/net/Uri;", "uri", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "parsePath", "(Landroid/net/Uri;)Ljava/lang/String;", "Landroid/content/ContentValues;", "values", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "readEnabledFlag", "(Landroid/content/ContentValues;)Ljava/lang/Boolean;", "channelIdFromChannelsEnableUri", "getCallerPackage", "()Ljava/lang/String;", "checkReadConfigPermission", "checkWriteConfigPermission", "checkWriteExtensionsPermission", "checkGatewayManagerPermission", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getCallingUidOrSelf", "()I", "permission", "enforceCallingPermission", "(Ljava/lang/String;)V", "onCreate", "()Z", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "projection", "selection", "selectionArgs", "sortOrder", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "insert", "(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;", ExtensionCallContract.OP_UPDATE, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "method", "arg", "Landroid/os/Bundle;", ExtensionCallContract.KEY_EXTRAS, "call", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;", "Lcom/stepos/stepclaw/provider/handlers/ConfigModelHandler;", "configHandler", "Lcom/stepos/stepclaw/provider/handlers/ConfigModelHandler;", "Lcom/stepos/stepclaw/provider/handlers/CoreFilesHandler;", "coreHandler", "Lcom/stepos/stepclaw/provider/handlers/CoreFilesHandler;", "Lcom/stepos/stepclaw/provider/handlers/SkillsHandler;", "skillsHandler", "Lcom/stepos/stepclaw/provider/handlers/SkillsHandler;", "Lcom/stepos/stepclaw/provider/handlers/ToolsHandler;", "toolsHandler", "Lcom/stepos/stepclaw/provider/handlers/ToolsHandler;", "Lcom/stepos/stepclaw/provider/handlers/CronjobsHandler;", "cronjobsHandler", "Lcom/stepos/stepclaw/provider/handlers/CronjobsHandler;", "Lcom/stepos/stepclaw/provider/handlers/CronRunLogsHandler;", "cronRunLogsHandler", "Lcom/stepos/stepclaw/provider/handlers/CronRunLogsHandler;", "Lcom/stepos/stepclaw/provider/handlers/ChannelsHandler;", "channelsHandler", "Lcom/stepos/stepclaw/provider/handlers/ChannelsHandler;", "Lcom/stepos/stepclaw/provider/handlers/GatewayManagerHandler;", "gatewayManagerHandler", "Lcom/stepos/stepclaw/provider/handlers/GatewayManagerHandler;", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OpenClawProvider extends ContentProvider {
    public static final String AUTHORITY = "com.stepos.stepclaw.provider";
    private static final String GATEWAY_MANAGER = "com.stepos.aios.stepclaw.permission.GATEWAY_MANAGER";
    private static final String READ_CONFIG = "com.stepos.aios.stepclaw.permission.READ_CONFIG";
    private static final String WRITE_CONFIG = "com.stepos.aios.stepclaw.permission.WRITE_CONFIG";
    private static final String WRITE_EXTENSIONS = "com.stepos.aios.stepclaw.permission.WRITE_EXTENSIONS";
    private ChannelsHandler channelsHandler;
    private ConfigModelHandler configHandler;
    private CoreFilesHandler coreHandler;
    private CronRunLogsHandler cronRunLogsHandler;
    private CronjobsHandler cronjobsHandler;
    private GatewayManagerHandler gatewayManagerHandler;
    private SkillsHandler skillsHandler;
    private ToolsHandler toolsHandler;

    private final String channelIdFromChannelsEnableUri(Uri uri) {
        int iIndexOf;
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments == null || (iIndexOf = pathSegments.indexOf("enable")) < 0 || iIndexOf >= n.j0(pathSegments)) {
            return null;
        }
        String strA0 = m.A0(pathSegments.subList(iIndexOf + 1, pathSegments.size()), "/", null, null, null, 62);
        if (x5.n.t1(strA0)) {
            return null;
        }
        return strA0;
    }

    private final void checkGatewayManagerPermission() {
        enforceCallingPermission(GATEWAY_MANAGER);
    }

    private final void checkReadConfigPermission() {
        enforceCallingPermission(READ_CONFIG);
    }

    private final void checkWriteConfigPermission() {
        enforceCallingPermission(WRITE_CONFIG);
    }

    private final void checkWriteExtensionsPermission() {
        enforceCallingPermission(WRITE_EXTENSIONS);
    }

    private final void enforceCallingPermission(String permission) {
        Context context = getContext();
        if (context == null || getCallingUidOrSelf() == Process.myUid() || context.checkCallingPermission(permission) == 0) {
            return;
        }
        throw new SecurityException(permission + " required: caller=" + getCallerPackage() + " was not granted it.");
    }

    private final void ensureHandlers() {
        initHandlersIfNeeded();
        if (this.configHandler == null) {
            throw new IllegalStateException("OpenClawProviderBackend not installed. Ensure Application.attachBaseContext() calls install().");
        }
    }

    private final String getCallerPackage() {
        try {
            Context context = getContext();
            p.b(context);
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
            if (packagesForUid == null) {
                return "unknown";
            }
            String str = packagesForUid.length == 0 ? null : packagesForUid[0];
            return str != null ? str : "unknown";
        } catch (Exception unused) {
            return "unknown";
        }
    }

    private final int getCallingUidOrSelf() {
        try {
            return Binder.getCallingUid();
        } catch (Exception unused) {
            return Process.myUid();
        }
    }

    private final void initHandlersIfNeeded() {
        OpenClawProviderBackend.Backend backend;
        if (this.configHandler == null && (backend = OpenClawProviderBackend.INSTANCE.get()) != null) {
            Context context = getContext();
            p.b(context);
            this.configHandler = new ConfigModelHandler(backend.getConfig());
            this.coreHandler = new CoreFilesHandler(backend.getRootfs());
            this.skillsHandler = new SkillsHandler(context, backend.getRootfs(), AUTHORITY);
            this.toolsHandler = new ToolsHandler(context, backend.getRootfs(), AUTHORITY);
            this.cronjobsHandler = new CronjobsHandler(context, backend.getRootfs(), AUTHORITY);
            this.cronRunLogsHandler = new CronRunLogsHandler(backend.getRootfs());
            this.channelsHandler = new ChannelsHandler(context, backend.getRootfs());
            this.gatewayManagerHandler = new GatewayManagerHandler(backend.getGatewayManager());
        }
    }

    private final String parsePath(Uri uri) {
        String path;
        if (p.a(uri.getAuthority(), AUTHORITY) && (path = uri.getPath()) != null) {
            return x5.n.X1(path, '/');
        }
        return null;
    }

    private final Cursor queryGatewayAuthToken() {
        Context context = getContext();
        if (context == null) {
            throw new IllegalStateException("Provider context unavailable");
        }
        String orCreate = DeviceGatewayTokenStore.INSTANCE.getOrCreate(context);
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{GatewayAuthConstants.AUTH_MODE});
        matrixCursor.addRow(new String[]{orCreate});
        return matrixCursor;
    }

    private final Boolean readEnabledFlag(ContentValues values) {
        if (!values.containsKey(ExtensionCallContract.ENABLED)) {
            return null;
        }
        Object obj = values.get(ExtensionCallContract.ENABLED);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() != 0);
        }
        if (obj instanceof String) {
            return Boolean.valueOf(((String) obj).equalsIgnoreCase("true") || obj.equals("1"));
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a1  */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.os.Bundle call(java.lang.String r8, java.lang.String r9, android.os.Bundle r10) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.provider.OpenClawProvider.call(java.lang.String, java.lang.String, android.os.Bundle):android.os.Bundle");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        String path;
        p.e(uri, "uri");
        initHandlersIfNeeded();
        if (this.configHandler != null && (path = parsePath(uri)) != null) {
            if (u.c1(path, "skills/", false) && !path.equals("skills") && !path.equals("skills/install") && !u.c1(path, "skills/update/", false)) {
                checkWriteExtensionsPermission();
                String strB1 = x5.n.B1(path, "skills/");
                SkillsHandler skillsHandler = this.skillsHandler;
                p.b(skillsHandler);
                return skillsHandler.delete(strB1);
            }
            if (u.c1(path, "tools/", false) && !path.equals("tools") && !path.equals("tools/install") && !u.c1(path, "tools/update/", false)) {
                checkWriteExtensionsPermission();
                String strB12 = x5.n.B1(path, "tools/");
                ToolsHandler toolsHandler = this.toolsHandler;
                p.b(toolsHandler);
                return toolsHandler.delete(strB12);
            }
            if (u.c1(path, "cronjobs/", false) && !path.equals("cronjobs") && !path.equals("cronjobs/add")) {
                checkWriteConfigPermission();
                String strB13 = x5.n.B1(path, "cronjobs/");
                CronjobsHandler cronjobsHandler = this.cronjobsHandler;
                p.b(cronjobsHandler);
                return cronjobsHandler.delete(strB13);
            }
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        p.e(uri, "uri");
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
    
        if (r0.equals("config/openclaw/reset") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
    
        if (r0.equals("config/model/restore-backup") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
    
        checkWriteConfigPermission();
        r3 = a6.r0.f210a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0079, code lost:
    
        if (((java.lang.Boolean) a6.i0.u(h6.d.f3059c, new com.stepos.stepclaw.provider.OpenClawProvider$insert$ok$1(null))).booleanValue() == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007c, code lost:
    
        return null;
     */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.net.Uri insert(android.net.Uri r4, android.content.ContentValues r5) {
        /*
            r3 = this;
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.p.e(r4, r0)
            r3.initHandlersIfNeeded()
            java.lang.String r0 = r3.parsePath(r4)
            r1 = 0
            if (r0 != 0) goto L10
            return r1
        L10:
            int r2 = r0.hashCode()
            switch(r2) {
                case -1988041738: goto L7d;
                case -1626345932: goto L5a;
                case -244505130: goto L51;
                case -94725915: goto L2e;
                case 117677380: goto L19;
                default: goto L17;
            }
        L17:
            goto L85
        L19:
            java.lang.String r5 = "gateway/restart"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L22
            goto L85
        L22:
            r3.checkGatewayManagerPermission()
            com.stepos.stepclaw.provider.handlers.GatewayManagerHandler r3 = r3.gatewayManagerHandler
            kotlin.jvm.internal.p.b(r3)
            r3.restart()
            return r4
        L2e:
            java.lang.String r5 = "core/workspace/reset"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L37
            goto L85
        L37:
            r3.checkWriteConfigPermission()
            h6.e r3 = a6.r0.f210a
            h6.d r3 = h6.d.f3059c
            com.stepos.stepclaw.provider.OpenClawProvider$insert$ok$2 r5 = new com.stepos.stepclaw.provider.OpenClawProvider$insert$ok$2
            r5.<init>(r1)
            java.lang.Object r3 = a6.i0.u(r3, r5)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L50
            goto L7b
        L50:
            return r1
        L51:
            java.lang.String r5 = "config/openclaw/reset"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L63
            goto L85
        L5a:
            java.lang.String r5 = "config/model/restore-backup"
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L63
            goto L85
        L63:
            r3.checkWriteConfigPermission()
            h6.e r3 = a6.r0.f210a
            h6.d r3 = h6.d.f3059c
            com.stepos.stepclaw.provider.OpenClawProvider$insert$ok$1 r5 = new com.stepos.stepclaw.provider.OpenClawProvider$insert$ok$1
            r5.<init>(r1)
            java.lang.Object r3 = a6.i0.u(r3, r5)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L7c
        L7b:
            return r4
        L7c:
            return r1
        L7d:
            java.lang.String r4 = "cronjobs/add"
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L86
        L85:
            return r1
        L86:
            if (r5 != 0) goto L89
            return r1
        L89:
            com.stepos.stepclaw.provider.handlers.CronjobsHandler r4 = r3.cronjobsHandler
            if (r4 != 0) goto L8e
            return r1
        L8e:
            r3.checkWriteConfigPermission()
            com.stepos.stepclaw.provider.handlers.CronjobsHandler r3 = r3.cronjobsHandler
            kotlin.jvm.internal.p.b(r3)
            android.net.Uri r3 = r3.add(r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.provider.OpenClawProvider.insert(android.net.Uri, android.content.ContentValues):android.net.Uri");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (getContext() == null) {
            return false;
        }
        initHandlersIfNeeded();
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String path;
        p.e(uri, "uri");
        initHandlersIfNeeded();
        if (this.configHandler == null || (path = parsePath(uri)) == null) {
            return null;
        }
        if (!path.equals("gateway/auth_token") && u.c1(path, "gateway/", false)) {
            checkGatewayManagerPermission();
        } else {
            checkReadConfigPermission();
        }
        ConfigModelHandler configModelHandler = this.configHandler;
        p.b(configModelHandler);
        CoreFilesHandler coreFilesHandler = this.coreHandler;
        p.b(coreFilesHandler);
        GatewayManagerHandler gatewayManagerHandler = this.gatewayManagerHandler;
        p.b(gatewayManagerHandler);
        SkillsHandler skillsHandler = this.skillsHandler;
        p.b(skillsHandler);
        ToolsHandler toolsHandler = this.toolsHandler;
        p.b(toolsHandler);
        CronjobsHandler cronjobsHandler = this.cronjobsHandler;
        p.b(cronjobsHandler);
        ChannelsHandler channelsHandler = this.channelsHandler;
        p.b(channelsHandler);
        if (path.equals("config/model")) {
            return configModelHandler.query();
        }
        if (u.c1(path, "core/", false)) {
            return coreFilesHandler.query(x5.n.B1(path, "core/"));
        }
        if (path.equals("gateway/auth_token")) {
            return queryGatewayAuthToken();
        }
        if (path.equals("gateway/status")) {
            return gatewayManagerHandler.query();
        }
        if (path.equals("skills")) {
            return skillsHandler.query();
        }
        if (path.equals("tools")) {
            return toolsHandler.query();
        }
        if (path.equals("cronjobs")) {
            return cronjobsHandler.query();
        }
        if (path.equals("cron/run_logs")) {
            CronRunLogsHandler cronRunLogsHandler = this.cronRunLogsHandler;
            p.b(cronRunLogsHandler);
            return cronRunLogsHandler.query(uri);
        }
        if (path.equals("channels")) {
            return channelsHandler.query();
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        String path;
        p.e(uri, "uri");
        if (values != null) {
            initHandlersIfNeeded();
            if (this.configHandler != null && (path = parsePath(uri)) != null) {
                if (path.equals("config/model")) {
                    checkWriteConfigPermission();
                    ConfigModelHandler configModelHandler = this.configHandler;
                    p.b(configModelHandler);
                    return configModelHandler.update(values);
                }
                if (u.c1(path, "core/", false)) {
                    checkWriteConfigPermission();
                    CoreFilesHandler coreFilesHandler = this.coreHandler;
                    p.b(coreFilesHandler);
                    return coreFilesHandler.update(x5.n.B1(path, "core/"), values);
                }
                if (u.c1(path, "skills/update/", false)) {
                    checkWriteExtensionsPermission();
                    String strB1 = x5.n.B1(path, "skills/update/");
                    SkillsHandler skillsHandler = this.skillsHandler;
                    p.b(skillsHandler);
                    return SkillsHandler.update$default(skillsHandler, strB1, values, null, null, 12, null);
                }
                if (u.c1(path, "tools/update/", false)) {
                    checkWriteExtensionsPermission();
                    String strB12 = x5.n.B1(path, "tools/update/");
                    ToolsHandler toolsHandler = this.toolsHandler;
                    p.b(toolsHandler);
                    return ToolsHandler.update$default(toolsHandler, strB12, values, null, 4, null);
                }
                if (u.c1(path, "skills/enable/", false)) {
                    checkWriteConfigPermission();
                    String strB13 = x5.n.B1(path, "skills/enable/");
                    Boolean enabledFlag = readEnabledFlag(values);
                    if (enabledFlag != null) {
                        boolean zBooleanValue = enabledFlag.booleanValue();
                        SkillsHandler skillsHandler2 = this.skillsHandler;
                        p.b(skillsHandler2);
                        return skillsHandler2.setEnable(strB13, zBooleanValue);
                    }
                } else if (u.c1(path, "tools/enable/", false)) {
                    checkWriteConfigPermission();
                    String strB14 = x5.n.B1(path, "tools/enable/");
                    Boolean enabledFlag2 = readEnabledFlag(values);
                    if (enabledFlag2 != null) {
                        boolean zBooleanValue2 = enabledFlag2.booleanValue();
                        ToolsHandler toolsHandler2 = this.toolsHandler;
                        p.b(toolsHandler2);
                        return toolsHandler2.setEnable(strB14, zBooleanValue2);
                    }
                } else if (u.c1(path, "cronjobs/enable/", false)) {
                    checkWriteConfigPermission();
                    String strB15 = x5.n.B1(path, "cronjobs/enable/");
                    Boolean enabledFlag3 = readEnabledFlag(values);
                    if (enabledFlag3 != null) {
                        boolean zBooleanValue3 = enabledFlag3.booleanValue();
                        CronjobsHandler cronjobsHandler = this.cronjobsHandler;
                        p.b(cronjobsHandler);
                        return cronjobsHandler.setEnabled(strB15, zBooleanValue3);
                    }
                } else if (u.c1(path, "channels/enable/", false)) {
                    checkWriteConfigPermission();
                    String strChannelIdFromChannelsEnableUri = channelIdFromChannelsEnableUri(uri);
                    if (strChannelIdFromChannelsEnableUri == null) {
                        strChannelIdFromChannelsEnableUri = x5.n.B1(path, "channels/enable/");
                        if (strChannelIdFromChannelsEnableUri.length() <= 0) {
                            strChannelIdFromChannelsEnableUri = null;
                        }
                    }
                    if (strChannelIdFromChannelsEnableUri != null && strChannelIdFromChannelsEnableUri.length() != 0) {
                        Boolean enabledFlag4 = readEnabledFlag(values);
                        if (enabledFlag4 == null) {
                            ALog.w$default("OpenClawProvider", "channels/enable: missing or invalid 'enabled' keys=" + values.keySet() + " uri=" + uri, null, 4, null);
                            return 0;
                        }
                        ChannelsHandler channelsHandler = this.channelsHandler;
                        p.b(channelsHandler);
                        int enabled = channelsHandler.setEnabled(strChannelIdFromChannelsEnableUri, enabledFlag4.booleanValue());
                        ALog.i$default("OpenClawProvider", "channels/enable: channelId=" + strChannelIdFromChannelsEnableUri + " enabled=" + enabledFlag4 + " rows=" + enabled + " caller=" + getCallerPackage(), null, 4, null);
                        return enabled;
                    }
                    ALog.w$default("OpenClawProvider", "channels/enable: empty channelId uri=" + uri + " path=" + path, null, 4, null);
                }
            }
        }
        return 0;
    }
}
