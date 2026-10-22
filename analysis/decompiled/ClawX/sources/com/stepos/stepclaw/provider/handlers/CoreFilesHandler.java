package com.stepos.stepclaw.provider.handlers;

import a6.f0;
import a6.i0;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import b5.a0;
import b5.g;
import c5.m;
import c5.z;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.framework.ServiceLocator;
import com.stepos.stepclaw.bridge.memory.MemoryBridge;
import com.stepos.stepclaw.provider.backend.IRootfsAccess;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import f5.c;
import g5.a;
import h5.e;
import h5.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import p5.p;
import x5.l;
import x5.n;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0012\u001a\u00020\r2\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0010\"\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u000fJ\u001d\u0010\u0018\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/stepclaw/provider/handlers/CoreFilesHandler;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;", "rootfs", "<init>", "(Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "buildAggregatedMemoryContentForQuery", "()Ljava/lang/String;", "pathSegments", "resolvePath", "(Ljava/lang/String;)Ljava/lang/String;", "content", "Landroid/database/Cursor;", "cursorWithContent", "(Ljava/lang/String;)Landroid/database/Cursor;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "columns", "emptyCursor", "([Ljava/lang/String;)Landroid/database/Cursor;", "query", "Landroid/content/ContentValues;", "values", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ExtensionCallContract.OP_UPDATE, "(Ljava/lang/String;Landroid/content/ContentValues;)I", "Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "filenameMap", "Ljava/util/Map;", "Lx5/l;", "dailyMemoryNamePattern", "Lx5/l;", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CoreFilesHandler {
    private final l dailyMemoryNamePattern;
    private final Map<String, String> filenameMap;
    private final IRootfsAccess rootfs;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.provider.handlers.CoreFilesHandler$buildAggregatedMemoryContentForQuery$3", f = "CoreFilesHandler.kt", l = {71}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.provider.handlers.CoreFilesHandler$buildAggregatedMemoryContentForQuery$3, reason: invalid class name */
    public static final class AnonymousClass3 extends i implements p {
        int label;

        public AnonymousClass3(c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final c create(Object obj, c cVar) {
            return new AnonymousClass3(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, c cVar) {
            return ((AnonymousClass3) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            a aVar = a.f2984a;
            int i8 = this.label;
            if (i8 != 0) {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                a.a.c0(obj);
                return obj;
            }
            a.a.c0(obj);
            MemoryBridge memoryBridge = (MemoryBridge) ServiceLocator.INSTANCE.get(MemoryBridge.class);
            this.label = 1;
            Object stepMemAsString$default = MemoryBridge.readStepMemAsString$default(memoryBridge, null, null, null, true, false, this, 23, null);
            return stepMemAsString$default == aVar ? aVar : stepMemAsString$default;
        }
    }

    public CoreFilesHandler(IRootfsAccess rootfs) {
        kotlin.jvm.internal.p.e(rootfs, "rootfs");
        this.rootfs = rootfs;
        this.filenameMap = z.U(new g("soul", "SOUL.md"), new g("agent", "AGENTS.md"), new g("agents", "AGENTS.md"), new g("user", "USER.md"), new g("memory", "MEMORY.md"), new g("tools", "TOOLS.md"), new g("identity", "IDENTITY.md"));
        this.dailyMemoryNamePattern = new l("^\\d{4}-\\d{2}-\\d{2}\\.md$");
    }

    private final String buildAggregatedMemoryContentForQuery() throws Throwable {
        ArrayList arrayList = new ArrayList();
        String rootfsFile = this.rootfs.readRootfsFile("root/.openclaw/workspace/MEMORY.md");
        if (rootfsFile != null) {
            if (n.t1(rootfsFile)) {
                rootfsFile = null;
            }
            if (rootfsFile != null) {
                arrayList.add("## MEMORY.md (long-term)\n\n".concat(rootfsFile));
            }
        }
        List<String> listListRootfsFilesInDirectory = this.rootfs.listRootfsFilesInDirectory("root/.openclaw/workspace/memory");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listListRootfsFilesInDirectory) {
            if (this.dailyMemoryNamePattern.e((String) obj)) {
                arrayList2.add(obj);
            }
        }
        for (String str : m.I0(arrayList2)) {
            String rootfsFile2 = this.rootfs.readRootfsFile("root/.openclaw/workspace/memory/" + str);
            if (rootfsFile2 != null) {
                if (n.t1(rootfsFile2)) {
                    rootfsFile2 = null;
                }
                if (rootfsFile2 != null) {
                    arrayList.add("## memory/" + str + "\n\n" + rootfsFile2);
                }
            }
        }
        Object objU = i0.u(f5.i.f2626a, new AnonymousClass3(null));
        if (n.t1((String) objU)) {
            objU = null;
        }
        String str2 = (String) objU;
        if (str2 != null) {
            arrayList.add("## stepmem\n\n".concat(str2));
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return m.A0(arrayList, "\n\n---\n\n", null, null, null, 62);
    }

    private final Cursor cursorWithContent(String content) {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"content"});
        matrixCursor.addRow(new String[]{content});
        return matrixCursor;
    }

    private final Cursor emptyCursor(String... columns) {
        return new MatrixCursor(columns);
    }

    private final String resolvePath(String pathSegments) {
        String str = this.filenameMap.get(pathSegments);
        if (str != null) {
            return "root/.openclaw/workspace/".concat(str);
        }
        if (!u.c1(pathSegments, "skills/", false)) {
            return "root/.openclaw/workspace/".concat(pathSegments);
        }
        String strB1 = n.B1(pathSegments, "skills/");
        String strConcat = "root/.openclaw/skills/".concat(strB1);
        return this.rootfs.readRootfsFile(strConcat) != null ? strConcat : "usr/local/lib/node_modules/openclaw/skills/".concat(strB1);
    }

    public final Cursor query(String pathSegments) throws Throwable {
        kotlin.jvm.internal.p.e(pathSegments, "pathSegments");
        if (pathSegments.equals("memory")) {
            String strBuildAggregatedMemoryContentForQuery = buildAggregatedMemoryContentForQuery();
            return strBuildAggregatedMemoryContentForQuery == null ? emptyCursor("content") : cursorWithContent(strBuildAggregatedMemoryContentForQuery);
        }
        String strResolvePath = resolvePath(pathSegments);
        if (strResolvePath == null) {
            return null;
        }
        String rootfsFile = this.rootfs.readRootfsFile(strResolvePath);
        return rootfsFile == null ? emptyCursor("content") : cursorWithContent(rootfsFile);
    }

    public final int update(String pathSegments, ContentValues values) {
        String strResolvePath;
        kotlin.jvm.internal.p.e(pathSegments, "pathSegments");
        kotlin.jvm.internal.p.e(values, "values");
        String asString = values.getAsString("content");
        if (asString == null || (strResolvePath = resolvePath(pathSegments)) == null) {
            return 0;
        }
        this.rootfs.writeRootfsFile(strResolvePath, asString);
        return 1;
    }
}
