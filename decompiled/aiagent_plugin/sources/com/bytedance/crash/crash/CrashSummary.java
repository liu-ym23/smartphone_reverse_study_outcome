package com.bytedance.crash.crash;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.dumper.MemoryInfo;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.i;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.o.l;
import com.bytedance.crash.o.r;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.upload.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class CrashSummary implements Comparable {
    protected static final String SUFFIX = ".summary";
    private static final String UPLOAD_STATE = "upload_state.inf";
    protected final long mCrashTime;
    protected final CrashType mCrashType;
    protected final File mDirectory;
    protected final int mPid;
    protected final String mProcessName;
    protected String mStackTrace;
    protected final long mStartTime;
    protected final String mThreadName;
    protected final int mTid;
    protected final long sAppStartUpTime;

    public abstract void appendSpecialFilter(JSONObject r1);

    public abstract void assemblySpecialCrashBody(com.bytedance.crash.entity.a r1, Header r2);

    public JSONObject getOriginalBody(JSONObject r1) {
        return r1;
    }

    public abstract String loadStackTrace();

    public CrashSummary(File r1, CrashType r2, long r3, long r5, long r7, String r9, String r10, int r11, int r12) {
        this.mDirectory = r1;
        this.mCrashType = r2;
        this.mStartTime = r3;
        this.sAppStartUpTime = r5;
        this.mCrashTime = r7;
        this.mProcessName = r9;
        this.mThreadName = r10;
        this.mPid = r11;
        this.mTid = r12;
    }

    public int getPid() {
        return this.mPid;
    }

    public int getTid() {
        return this.mTid;
    }

    public long getCrashTime() {
        return this.mCrashTime;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public String getProcessName() {
        return this.mProcessName;
    }

    public String getThreadName() {
        return this.mThreadName;
    }

    public CrashType getCrashType() {
        return this.mCrashType;
    }

    public String getStackTrace() {
        return this.mStackTrace;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r4) {
        long r0 = this.mCrashTime - ((CrashSummary) ZeusTransformUtils.preCheckCast(r4, CrashSummary.class, "com.obric.aiagent.plugin")).mCrashTime;
        if (r0 <= 0) goto L5;
        return -1;
    L5:
        if (r0 >= 0) goto L7;
        return 1;
    L7:
        return 0;
    }

    public Header assemblyCrashHeader(com.bytedance.crash.monitor.a r9) {
        return Header.a(r9, this.mStartTime, this.mCrashTime, this.mCrashType, this.mPid, this.mDirectory);
    }

    public com.bytedance.crash.entity.a assemblyCrashBody(com.bytedance.crash.monitor.a r10) {
        Header r11 = Header.a(r10, this.mStartTime, this.mCrashTime, this.mCrashType, this.mPid, this.mDirectory);
        com.bytedance.crash.entity.a r1 = new com.bytedance.crash.entity.a();
        r1.a("pid", Integer.valueOf(this.mPid));     // Catch: Throwable -> L5
        r1.a("tid", Integer.valueOf(this.mTid));     // Catch: Throwable -> L5
        r1.a("crash_time", Long.valueOf(this.mCrashTime));     // Catch: Throwable -> L5
        r1.a("crash_thread_name", this.mThreadName);     // Catch: Throwable -> L5
        r1.a("process_name", this.mProcessName);     // Catch: Throwable -> L5
        r1.a("app_start_time", Long.valueOf(this.mStartTime));     // Catch: Throwable -> L5
        r1.a("app_start_up_time", Long.valueOf(this.sAppStartUpTime));     // Catch: Throwable -> L5
        r1.a("jiffy", Long.valueOf(r11.e()));     // Catch: Throwable -> L5
        r1.a("has_dump", "true");     // Catch: Throwable -> L5
        l.a(r1.c(), "business", i.a());     // Catch: Throwable -> L5
        r1.a("data", this.mStackTrace);     // Catch: Throwable -> L5
        r1.a("crash_md5", com.bytedance.crash.o.e.a(this.mStackTrace));     // Catch: Throwable -> L5
        r1.a("launch_mode", Integer.valueOf(ActivityLifecycle.d()));     // Catch: Throwable -> L5
        r1.a("launch_time", Long.valueOf(ActivityLifecycle.e()));     // Catch: Throwable -> L5
        r1.a("session_id", r11.b().opt("session_id"));     // Catch: Throwable -> L5
        loadCrashInfo(r1.c(), r11.b(), this.mDirectory);     // Catch: Throwable -> L5
        com.bytedance.crash.entity.b.a(r11.b(), r1.c(), this.mDirectory);     // Catch: Throwable -> L5
        assemblyCrashBodyAfterFilter(r1.c(), this.mDirectory);     // Catch: Throwable -> L5
        assemblySpecialCrashBody(r1, r11);     // Catch: Throwable -> L5
        appendSpecialFilter(r1.c());     // Catch: Throwable -> L5
    L8:
        return r1.a(r11);
    L5:
        th = move-exception;
        r.b(th);
        com.bytedance.crash.c.b.a(th);
        goto L8
    }

    private static void assemblyCrashBodyAfterFilter(JSONObject r1, File r2) {
        NativeBridge.r(r2.getAbsolutePath());
        MemoryInfo.b(r1, r2);
    }

    public void loadCrashInfo(JSONObject r1, JSONObject r2, File r3) {
        a.a(r1, r2, r3);
    }

    public static CrashSummary loadFromDirectory(File r6, boolean r7) {
        File[] r8 = r6.listFiles(new AnonymousClass1());
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList r1 = new ArrayList();
        int r2 = r8.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L17;
        File r5 = r8[r4];
        if (r7 == false) goto L12;
        NativeCrashSummary r9 = NativeCrashSummary.load(r5);
        if (r9 == null) goto L15;
        r1.add(r9);
    L15:
        r4 = r4 + 1;
        goto L6
    L12:
        e r10 = e.a(r5);
        if (r10 == null) goto L15;
        r1.add(r10);
        goto L15
    L17:
        if (r1.isEmpty() == false) goto L19;
        return null;
    L19:
        Collections.sort(r1, new AnonymousClass2());
        return (CrashSummary) ZeusTransformUtils.preCheckCast(r1.get(0), CrashSummary.class, "com.obric.aiagent.plugin");
    }

    public static CrashSummary loadFromDirectory(File r7) {
        File[] r8 = r7.listFiles(new AnonymousClass3());
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList r1 = new ArrayList();
        int r2 = r8.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L15;
        File r5 = r8[r4];
        NativeCrashSummary r6 = NativeCrashSummary.load(r5);
        if (r6 == null) goto L10;
        r1.add(r6);
    L10:
        e r9 = e.a(r5);
        if (r9 == null) goto L13;
        r1.add(r9);
    L13:
        r4 = r4 + 1;
        goto L6
    L15:
        if (r1.isEmpty() == false) goto L17;
        return null;
    L17:
        Collections.sort(r1, new AnonymousClass4());
        return (CrashSummary) ZeusTransformUtils.preCheckCast(r1.get(0), CrashSummary.class, "com.obric.aiagent.plugin");
    }

    boolean checkIfNeedUpload() {
        File r0 = new File(this.mDirectory, UPLOAD_STATE);
        int r2 = 0;
        if (r0.exists() == false) goto L24;
        FileInputStream r4 = new FileInputStream(r0);     // Catch: Exception -> L7
        int r3 = r4.read();     // Catch: Exception -> L7
        r4.close();     // Catch: Exception -> L18
    L9:
        if (r3 < 0) goto L13;
        if (r3 >= 2) goto L13;
        r2 = r3 + 1;
    L13:
        if (r3 < 2) goto L15;
        com.bytedance.crash.c.b.b("upload failed, retry count is" + r3 + ".", new Exception());
    L15:
        return false;
    L7:
        r3 = 0;
    L24:
        FileOutputStream r5 = new FileOutputStream(r0);     // Catch: Exception -> L19
        r5.write(r2);     // Catch: Exception -> L19
        r5.close();     // Catch: Exception -> L19
    L17:
        return true;
    }

    private void deleteDirectory() {
        r.b("delete directory=" + this.mDirectory.getAbsolutePath());
        com.bytedance.crash.o.i.c(this.mDirectory);
        if (this.mDirectory.exists() == false) goto L6;
        com.bytedance.crash.o.i.b(this.mDirectory, UPLOAD_STATE);
        return;
    }

    private void setInnerAid(JSONObject r3) {
        JSONObject r2 = r3.optJSONObject("header");
        JSONObject r4 = r3.optJSONObject("filters");
        if (r2 == null) goto L5;
        String r1 = String.valueOf(r2.opt(WsConstants.KEY_APP_ID));
    L6:
        l.a(r4, WsConstants.KEY_APP_ID, r1);
        l.a(r2, WsConstants.KEY_APP_ID, 2010);
        return;
    L5:
        r1 = "";
        goto L6
    }

    public boolean upload(com.bytedance.crash.monitor.a r7, JSONObject r8) {
        boolean r1 = false;
        if (checkIfNeedUpload() == true) goto L6;
        deleteDirectory();
        return false;
    L6:
        File r0 = new File(this.mDirectory, "upload.json");
        String r2 = com.bytedance.crash.o.i.d(r0);
        JSONObject r3 = null;
        if (r2 != null) goto L39;
        JSONObject r4 = null;
    L14:
        if (r3 == null) goto L43;
        if (r4 == null) goto L43;
        boolean r9 = false;
    L22:
        boolean r10 = beforeUpload(r7, r3);     // Catch: Throwable -> L31
        if (r10 == false) goto L37;
    L34:
        afterUpload(r3, r1, r10);
        r.b("uploadOne:" + this.mDirectory.getAbsolutePath() + ", success=" + r1);
        return r1;
    L37:
        String r5 = r3.toString();     // Catch: Throwable -> L29
        if (r9 == false) goto L27;
        com.bytedance.crash.o.i.c(r0, r5);     // Catch: Throwable -> L29
    L27:
        String r11 = o.a(this.mCrashType, r4);     // Catch: Throwable -> L29
        r.b("uploadOne: " + this.mCrashType + " :" + r11);     // Catch: Throwable -> L29
        r1 = com.bytedance.crash.upload.b.a(this.mCrashType.getName(), r11, r5, getAttachmentFileList()).a();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        boolean r12 = r10;
        th = th;
    L33:
        r.a(th);
        com.bytedance.crash.c.b.b("upload exception", th);
        r10 = r12;
    L31:
        th = th;
        r12 = false;
    L43:
        com.bytedance.crash.entity.a r6 = assemblyCrashBody(r7);     // Catch: Throwable -> L31
        r3 = r6.c();     // Catch: Throwable -> L31
        r4 = r6.b();     // Catch: Throwable -> L31
        JSONObject r13 = l.a(r3, "filters");     // Catch: Throwable -> L31
        if (r8 == null) goto L21;
        l.b(r13, r8);     // Catch: Throwable -> L31
    L21:
        r9 = true;
        goto L22
    L39:
        JSONObject r14 = new JSONObject(r2);     // Catch: JSONException -> L11
        r3 = r14.optJSONObject("header");     // Catch: JSONException -> L36
    L12:
        r4 = r3;
        r3 = r14;
    L11:
        r14 = null;
        goto L12
    }

    private boolean beforeUpload(com.bytedance.crash.monitor.a r4, JSONObject r5) {
        if (r4.n().a(this.mCrashType, r5) == false) goto L6;
        return true;
    L6:
        JSONObject r6 = getOriginalBody(r5);
        com.bytedance.crash.b.a(this.mCrashType, this.mCrashTime, r6);
        JSONObject r7 = r5.optJSONObject("header");
        g.a(this.mCrashType, this.mDirectory, r6, r7);
        return false;
    }

    private void afterUpload(JSONObject r7, boolean r8, boolean r9) {
        if (r8 == true) goto L9;
    L4:
        if (r8 == true) goto L6;
        if (r9 == true) goto L6;
        return;
    L6:
        deleteDirectory();     // Catch: Throwable -> L8
        com.bytedance.crash.a.b.d();     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L9:
        com.bytedance.crash.alog.a.a(this.mProcessName, this.mStartTime, this.mCrashTime, this.mCrashType);     // Catch: Throwable -> L8
        com.bytedance.crash.upload.a.a(this.mCrashType);     // Catch: Throwable -> L8
        goto L4
    }

    List<File> getAttachmentFileList() {
        ArrayList r0 = new ArrayList();
        File[] r6 = this.mDirectory.listFiles();
        if (r6 == null) goto L15;
        int r1 = r6.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L15;
        File r3 = r6[r2];
        String r4 = r3.getName();
        if (r4.endsWith(SUFFIX) == true) goto L14;
        if (r4.endsWith(".json") == true) goto L14;
        if (r4.endsWith(".inf") == true) goto L14;
        r0.add(r3);
    L14:
        r2 = r2 + 1;
    L15:
        return r0;
    }
}
