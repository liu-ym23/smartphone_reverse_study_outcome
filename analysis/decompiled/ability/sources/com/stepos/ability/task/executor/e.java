package com.stepos.ability.task.executor;

import C9.AbstractC0200b;
import C9.C0199a;
import C9.i;
import C9.q;
import D7.w;
import J8.k;
import T8.o;
import android.app.Application;
import android.app.ApplicationExitInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import b8.i0;
import ca.AbstractC0897f;
import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.utils.JsonType;
import com.stepos.ability.bean.GuiAgentConfig;
import com.stepos.ability.bean.TaskConfig;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.aiengine.args.SingleImageBundle;
import com.stepos.aiengine.data.InpaintImageAction;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.FileContent;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.base.Content;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.taskrobot.common.ITaskRobotManger;
import com.stepos.taskrobot.llmapi.stepfun.FullScreenActivityViewModel;
import com.uxsense.ApexSDK;
import d5.n;
import d9.InterfaceC1384e;
import g1.AbstractC1451a;
import h8.InterfaceC1519b;
import h8.InterfaceC1522e;
import h8.InterfaceC1527j;
import j9.m;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import k8.C1640i;
import k8.K;
import k8.Q;
import kotlin.Pair;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import r8.C1879a;
import t5.C2016a;
import u8.j;

/* loaded from: classes3.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f3312a = false;
    public static boolean b = false;
    public static String c = null;
    public static Method d = null;
    public static boolean e = true;
    public static boolean f = false;
    public static boolean g = false;
    public static String h = "";
    public static String i = null;

    /* renamed from: j, reason: collision with root package name */
    public static volatile ITaskRobotManger f3313j = null;
    public static volatile n6.c k = null;
    public static Application l = null;
    public static String m = "";

    public static Content A(Bundle bundle) {
        Bitmap bitmap = (Bitmap) bundle.getParcelable("bitmap");
        if (bitmap != null) {
            return n.b(ImageContent.Companion, bitmap, 0, 0, 0, 0, 30);
        }
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) bundle.getParcelable(SingleImageBundle.KEY_FILE_DESCRIPTOR);
        if (parcelFileDescriptor == null) {
            String string = bundle.getString(SingleFileBundle.KEY_PATH);
            if (string == null || m.s0(string)) {
                throw new IllegalArgumentException("SingleImageBundle has no usable image data (bitmap/fd/path)");
            }
            return new FileContent(string, "image/*", null, 4, null);
        }
        return new ImageContent(null, parcelFileDescriptor, 0L, 0, 0, 0, 0, null, null, 509, null);
    }

    public static Q B(G8.f fVar, InterfaceC1522e interfaceC1522e) {
        if (fVar == null) {
            a(19);
            throw null;
        }
        if (interfaceC1522e == null) {
            a(20);
            throw null;
        }
        Collection collectionN = interfaceC1522e.n();
        if (collectionN.size() != 1) {
            return null;
        }
        for (Q q5 : ((C1640i) collectionN.iterator().next()).x()) {
            if (q5.getName().equals(fVar)) {
                return q5;
            }
        }
        return null;
    }

    public static JsonType C(JsonNode jsonNode) {
        if (jsonNode.isTextual()) {
            String strTextValue = jsonNode.textValue();
            if ("object".equals(strTextValue)) {
                return JsonType.OBJECT;
            }
            if ("array".equals(strTextValue)) {
                return JsonType.ARRAY;
            }
            if (TypedValues.Custom.S_STRING.equals(strTextValue)) {
                return JsonType.STRING;
            }
            if ("number".equals(strTextValue)) {
                return JsonType.NUMBER;
            }
            if (TypedValues.Custom.S_INT.equals(strTextValue)) {
                return JsonType.INTEGER;
            }
            if (TypedValues.Custom.S_BOOLEAN.equals(strTextValue)) {
                return JsonType.BOOLEAN;
            }
            if ("any".equals(strTextValue)) {
                return JsonType.ANY;
            }
            if ("null".equals(strTextValue)) {
                return JsonType.NULL;
            }
        }
        return jsonNode.isArray() ? JsonType.UNION : JsonType.UNKNOWN;
    }

    public static JsonType D(JsonNode jsonNode, T6.a aVar) {
        if (jsonNode != null) {
            switch (E3.g.f467a[jsonNode.getNodeType().ordinal()]) {
                case 1:
                    return JsonType.OBJECT;
                case 2:
                    return JsonType.ARRAY;
                case 3:
                case 4:
                    return JsonType.STRING;
                case 5:
                    return jsonNode.isIntegralNumber() ? JsonType.INTEGER : JsonType.NUMBER;
                case 6:
                    return JsonType.BOOLEAN;
                case 7:
                    return JsonType.NULL;
            }
        }
        return JsonType.UNKNOWN;
    }

    public static Map E() {
        return kotlin.collections.a.R(new Pair(Constants.PARAM_PROTOCOL_VERSION, "2025-06-18"), new Pair("capabilities", kotlin.collections.a.Q(new Pair("tools", kotlin.collections.a.Q(new Pair("listChanged", Boolean.FALSE))))), new Pair("serverInfo", kotlin.collections.a.R(new Pair(HintConstants.AUTOFILL_HINT_NAME, "ability-mcp-server"), new Pair("version", ApexSDK.VERSION))), new Pair("instructions", "This server exposes on-device system capabilities of an Android phone.\nStandard MCP methods tools/list and tools/call are fully supported.\n\nPrivate extensions:\n- tools/search: BM25 search over tool descriptions (params: query, top_k)\n- tools/describe: full metadata for a single tool (params: name)\n- tools/batch: DAG-ordered batch execution with $ref result reuse (params: tasks, timeout_ms)\n\nWorking rules:\n- A device may register dozens to hundreds of tools. Prefer tools/search to\n  locate candidates by intent; do not rely on reading the whole tools/list.\n- Before calling an unfamiliar tool, use tools/describe to read its argument\n  schema and its `permissions` field.\n- `permissions` holds Android permission constants (e.g.\n  android.permission.SEND_SMS, ACCESS_FINE_LOCATION, READ_CONTACTS). Treat them\n  as the side-effect signal: confirm with the user before invoking a tool whose\n  permissions imply sending, deleting, paying, or reading personal data.\n  This server intentionally sends no `annotations` hints - absence is not a\n  guarantee that a tool is safe or read-only.\n- tools/call result matches FunctionCallResult: success, content,\n  structuredContent, errorCode, errorMsg, meta. Both content and\n  structuredContent may be present; do not drop either. Execution\n  failure is success=false in that result, not a JSON-RPC error.\n  Always inspect success and errorCode. A missing tool also comes\n  back this way, never as 404.\n- To treat permission/privacy cards (10304/10501) as that failure shape,\n  set params._meta.convert_permission_auth to JSON boolean true\n  (not the string \"true\"). Default is leave the success envelope as-is.\n- Rate limit is 120 calls/min per API key (burst 20); on 429 back off, do not\n  retry immediately. On 401 the API key itself is invalid or revoked - stop and\n  report it, retrying will not help.\n- Right after device boot tools/list may return an empty list while the search\n  index is still building. Retry rather than concluding the device has no\n  capabilities."));
    }

    public static String F(InterfaceC1384e interfaceC1384e, kotlin.reflect.jvm.internal.impl.load.java.descriptors.a aVar) {
        if (interfaceC1384e.a(aVar)) {
            return null;
        }
        return interfaceC1384e.getDescription();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean G(i0 i0Var) {
        if (i0Var instanceof Z7.m) {
            Field fieldE = AbstractC1451a.E(i0Var);
            if (!(fieldE != null ? fieldE.isAccessible() : true)) {
                return false;
            }
            Method methodF = AbstractC1451a.F(i0Var.getGetter());
            if (!(methodF != null ? methodF.isAccessible() : true)) {
                return false;
            }
            Method methodF2 = AbstractC1451a.F(((Z7.m) i0Var).getSetter());
            if (!(methodF2 != null ? methodF2.isAccessible() : true)) {
                return false;
            }
        } else {
            Field fieldE2 = AbstractC1451a.E(i0Var);
            if (!(fieldE2 != null ? fieldE2.isAccessible() : true)) {
                return false;
            }
            Method methodF3 = AbstractC1451a.F(i0Var.getGetter());
            if (!(methodF3 != null ? methodF3.isAccessible() : true)) {
                return false;
            }
        }
        return true;
    }

    public static LinkedHashSet H(G8.f fVar, Collection collection, Collection collection2, InterfaceC1522e interfaceC1522e, o oVar, k kVar, boolean z10) {
        if (fVar == null) {
            a(12);
            throw null;
        }
        if (collection == null) {
            a(13);
            throw null;
        }
        if (collection2 == null) {
            a(14);
            throw null;
        }
        if (interfaceC1522e == null) {
            a(15);
            throw null;
        }
        if (oVar == null) {
            a(16);
            throw null;
        }
        if (kVar == null) {
            a(17);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        kVar.h(fVar, collection, collection2, interfaceC1522e, new C1879a(oVar, linkedHashSet, z10));
        return linkedHashSet;
    }

    public static LinkedHashSet I(G8.f fVar, AbstractCollection abstractCollection, Collection collection, InterfaceC1522e interfaceC1522e, o oVar, k kVar) {
        if (fVar == null) {
            a(0);
            throw null;
        }
        if (collection == null) {
            a(2);
            throw null;
        }
        if (interfaceC1522e == null) {
            a(3);
            throw null;
        }
        if (oVar == null) {
            a(4);
            throw null;
        }
        if (kVar != null) {
            return H(fVar, abstractCollection, collection, interfaceC1522e, oVar, kVar, false);
        }
        a(5);
        throw null;
    }

    public static LinkedHashSet J(G8.f fVar, Collection collection, AbstractCollection abstractCollection, j jVar, o oVar, k kVar) {
        if (fVar == null) {
            a(6);
            throw null;
        }
        if (collection == null) {
            a(7);
            throw null;
        }
        if (jVar == null) {
            a(9);
            throw null;
        }
        if (oVar == null) {
            a(10);
            throw null;
        }
        if (kVar != null) {
            return H(fVar, collection, abstractCollection, jVar, oVar, kVar, true);
        }
        a(11);
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.os.Bundle K(com.stepos.core.data.ImageContent r6) throws android.system.ErrnoException {
        /*
            java.lang.String r0 = "content"
            kotlin.jvm.internal.k.f(r6, r0)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            android.graphics.Bitmap r1 = r6.getBitmap()
            if (r1 == 0) goto L15
            android.graphics.Bitmap r1 = r6.getBitmap()
            goto L59
        L15:
            android.os.SharedMemory r1 = r6.getSharedMemory()
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L3e
            android.os.SharedMemory r1 = r6.getSharedMemory()
            kotlin.jvm.internal.k.c(r1)
            java.nio.ByteBuffer r1 = r1.mapReadOnly()     // Catch: java.lang.Exception -> L58
            java.lang.String r4 = "mapReadOnly(...)"
            kotlin.jvm.internal.k.e(r1, r4)     // Catch: java.lang.Exception -> L58
            int r4 = r1.remaining()     // Catch: java.lang.Exception -> L58
            byte[] r5 = new byte[r4]     // Catch: java.lang.Exception -> L58
            r1.get(r5)     // Catch: java.lang.Exception -> L58
            android.os.SharedMemory.unmap(r1)     // Catch: java.lang.Exception -> L58
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r5, r2, r4)     // Catch: java.lang.Exception -> L58
            goto L59
        L3e:
            android.hardware.HardwareBuffer r1 = r6.getHwBuffer()
            if (r1 == 0) goto L58
            android.hardware.HardwareBuffer r1 = r6.getHwBuffer()
            kotlin.jvm.internal.k.c(r1)
            android.graphics.Bitmap r1 = android.graphics.Bitmap.wrapHardwareBuffer(r1, r3)
            if (r1 == 0) goto L58
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r1 = r1.copy(r3, r2)
            goto L59
        L58:
            r1 = r3
        L59:
            if (r1 == 0) goto L60
            java.lang.String r2 = "result_bitmap"
            r0.putParcelable(r2, r1)
        L60:
            java.lang.String r1 = "result_width"
            int r2 = r6.getWidth()
            r0.putInt(r1, r2)
            java.lang.String r1 = "result_height"
            int r2 = r6.getHeight()
            r0.putInt(r1, r2)
            java.lang.String r1 = "result_format"
            int r6 = r6.getFormat()
            r0.putInt(r1, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.task.executor.e.K(com.stepos.core.data.ImageContent):android.os.Bundle");
    }

    public static final TaskConfig L(com.stepos.ability.sdk.client.g gVar, Context context) {
        kotlin.jvm.internal.k.f(gVar, "<this>");
        GuiAgentConfig guiAgentConfig = new GuiAgentConfig(null, 2, 0, null, null, false, null, LocationRequestCompat.QUALITY_LOW_POWER, null);
        com.stepos.ability.sdk.client.f fVar = gVar.c;
        String string = fVar.f3251a;
        if (string == null) {
            string = UUID.randomUUID().toString();
            kotlin.jvm.internal.k.e(string, "toString(...)");
        }
        return new TaskConfig(string, gVar.f3252a, null, 1, fVar.b, null, null, null, null, guiAgentConfig, gVar.b, fVar.c, context.getPackageName(), 0, 8420, null);
    }

    public static /* synthetic */ void a(int i6) {
        String str = i6 != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i6 != 18 ? 3 : 2];
        switch (i6) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
        }
        if (i6 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i6) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i6 == 18) {
            throw new IllegalStateException(str2);
        }
    }

    public static q b(S7.k kVar) {
        C0199a from = AbstractC0200b.d;
        kotlin.jvm.internal.k.f(from, "from");
        C9.g gVar = new C9.g();
        i iVar = from.f321a;
        gVar.f325a = iVar.f327a;
        gVar.b = iVar.e;
        gVar.c = iVar.b;
        gVar.d = iVar.c;
        gVar.e = iVar.d;
        String str = iVar.f;
        gVar.f = str;
        gVar.g = iVar.g;
        gVar.h = iVar.h;
        gVar.i = iVar.f328j;
        gVar.f326j = iVar.i;
        gVar.k = from.b;
        kVar.invoke(gVar);
        if (gVar.e) {
            if (!kotlin.jvm.internal.k.b(str, "    ")) {
                for (int i6 = 0; i6 < str.length(); i6++) {
                    char cCharAt = str.charAt(i6);
                    if (cCharAt != ' ' && cCharAt != '\t' && cCharAt != '\r' && cCharAt != '\n') {
                        throw new IllegalArgumentException("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had ".concat(str).toString());
                    }
                }
            }
        } else if (!kotlin.jvm.internal.k.b(str, "    ")) {
            throw new IllegalArgumentException("Indent should not be specified when default printing mode is used");
        }
        i iVar2 = new i(gVar.f325a, gVar.c, gVar.d, gVar.e, gVar.b, gVar.f, gVar.g, gVar.h, gVar.f326j, gVar.i);
        E9.e module = gVar.k;
        kotlin.jvm.internal.k.f(module, "module");
        q qVar = new q(iVar2, module);
        if (module.equals(E9.g.f499a)) {
            return qVar;
        }
        D9.n nVar = new D9.n();
        nVar.f443a = iVar2.h;
        nVar.b = iVar2.f328j != ClassDiscriminatorMode.f5263a;
        module.a(nVar);
        return qVar;
    }

    public static String c() throws ClassNotFoundException {
        boolean z10;
        String string;
        if (b && !TextUtils.isEmpty(c)) {
            return c;
        }
        boolean z11 = true;
        try {
            Class.forName("miui.os.Build");
            f3312a = true;
            z10 = true;
        } catch (Exception unused) {
            z10 = f3312a;
        }
        String str = "";
        if (z10) {
            try {
                Class.forName("miui.os.Build");
                f3312a = true;
            } catch (Exception unused2) {
                z11 = f3312a;
            }
            if (z11) {
                str = "miui_" + g("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
            }
        } else {
            string = Build.DISPLAY;
            if (!string.contains("Flyme") && !"flyme".equals(Build.USER)) {
                String str2 = Build.MANUFACTURER;
                if (!TextUtils.isEmpty(str2) ? str2.toLowerCase(Locale.getDefault()).contains("oppo") : false) {
                    if (TextUtils.isEmpty(str2) ? false : str2.toLowerCase(Locale.getDefault()).contains("oppo")) {
                        str = "coloros_" + g("ro.build.version.opporom") + "_" + string;
                    }
                } else {
                    String strG = g("ro.build.version.emui");
                    String strB = (strG == null || !strG.toLowerCase(Locale.getDefault()).contains("emotionui")) ? "" : B7.a.B(strG, "_", string);
                    if (TextUtils.isEmpty(strB)) {
                        String strG2 = g("ro.vivo.os.build.display.id");
                        if (!TextUtils.isEmpty(strG2) && strG2.toLowerCase(Locale.getDefault()).contains("funtouch")) {
                            string = g("ro.vivo.os.build.display.id") + "_" + g("ro.vivo.product.version");
                        } else {
                            if (!TextUtils.isEmpty(string) && string.toLowerCase(Locale.getDefault()).contains("amigo")) {
                                StringBuilder sbX = androidx.appfunctions.metadata.a.x(string, "_");
                                sbX.append(g("ro.gn.sv.version"));
                                string = sbX.toString();
                            } else {
                                StringBuilder sbV = androidx.compose.foundation.b.v(str2);
                                sbV.append(Build.BRAND);
                                String string2 = sbV.toString();
                                if (!TextUtils.isEmpty(string2)) {
                                    String lowerCase = string2.toLowerCase(Locale.getDefault());
                                    if (lowerCase.contains("360") || lowerCase.contains("qiku")) {
                                        z = true;
                                    }
                                }
                                if (z) {
                                    string = g("ro.build.uiversion") + "_" + string;
                                } else {
                                    if (!TextUtils.isEmpty(g("ro.letv.release.version"))) {
                                        str = "eui_" + g("ro.letv.release.version") + "_" + string;
                                    }
                                    if (TextUtils.isEmpty(str)) {
                                        b = true;
                                    }
                                }
                            }
                        }
                        c = string;
                        return string;
                    }
                    str = strB;
                }
            } else if (string.toLowerCase(Locale.getDefault()).contains("flyme")) {
                str = string;
            }
        }
        string = str;
        c = string;
        return string;
    }

    public static String d(long j5) {
        if (j5 == 0) {
            return "not obtained";
        }
        try {
            long j6 = j5 / 1024;
            return j6 >= 1 ? j6 <= 30 ? "[1~30MB]" : (j6 <= 30 || j6 > 60) ? (j6 <= 60 || j6 > 100) ? (j6 <= 100 || j6 > 200) ? (j6 <= 200 || j6 > 300) ? (j6 <= 300 || j6 > 400) ? (j6 <= 400 || j6 > 500) ? (j6 <= 500 || j6 > 600) ? (j6 <= 600 || j6 > 700) ? (j6 <= 700 || j6 > 800) ? (j6 <= 800 || j6 > 900) ? (j6 <= 900 || j6 > 1000) ? (j6 <= 1000 || j6 > 1500) ? (j6 <= 1500 || j6 > 2000) ? (j6 <= 2000 || j6 > 3000) ? (j6 <= 3000 || j6 > 4000) ? (j6 <= 4000 || j6 > 6000) ? (j6 <= 6000 || j6 > FullScreenActivityViewModel.OVERLAY_RESUME_FALLBACK_MS) ? ">8G" : "(6GB~8GB]" : "(4GB~6GB]" : "(3GB~4GB]" : "(2GB~3GB]" : "(1.5GB~2GB]" : "(1GB~1.5GB]" : "(900~1000MB]" : "(800~900MB]" : "(700~800MB]" : "(600~700MB]" : "(500~600MB]" : "(400~500MB]" : "(300~400MB]" : "(200~300MB]" : "(100~150MB]" : "(60~100MB]" : "(30~100MB]" : "< 1MB";
        } catch (Throwable unused) {
            return "invalid";
        }
    }

    public static String e(ApplicationExitInfo applicationExitInfo) {
        return "ApplicationExitInfo\n\tProcess : " + applicationExitInfo.getProcessName() + "(" + applicationExitInfo.getPid() + ")\n\tTime : " + AbstractC1451a.i().format(new Date(applicationExitInfo.getTimestamp())) + "\n\tReason : " + applicationExitInfo.getReason() + " (" + p(applicationExitInfo.getReason()) + ")\n\tRSS = " + applicationExitInfo.getRss() + "\n\tPSS = " + applicationExitInfo.getPss() + "\n\tDescription : " + applicationExitInfo.getDescription() + "\n\tStatus = " + applicationExitInfo.getStatus() + "\n\tImportance = " + applicationExitInfo.getImportance();
    }

    public static String f(Context context) throws IOException {
        if (TextUtils.isEmpty(m)) {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream inputStreamOpen = null;
            try {
                inputStreamOpen = context.getAssets().open("apmplus_hybrid/apmplus.hybrid.cn.js");
            } catch (Exception unused) {
                if (inputStreamOpen != null) {
                    break;
                }
            } catch (Throwable th) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
            while (true) {
                int i6 = inputStreamOpen.read(bArr);
                if (i6 != -1) {
                    byteArrayOutputStream.write(bArr, 0, i6);
                }
                try {
                    break;
                } catch (Exception unused3) {
                }
            }
            inputStreamOpen.close();
            m = byteArrayOutputStream.toString();
        }
        return B7.a.q(new StringBuilder(" javascript:(  function(){ "), m, " }  )() ");
    }

    public static String g(String str) {
        String str2;
        Process processExec;
        BufferedReader bufferedReader;
        String line = "";
        BufferedReader bufferedReader2 = null;
        try {
            if (d == null) {
                d = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            }
            str2 = (String) d.invoke(null, str);
        } catch (Exception e6) {
            e6.printStackTrace();
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        try {
            processExec = Runtime.getRuntime().exec("getprop ".concat(str));
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
        } catch (Throwable unused) {
        }
        try {
            line = bufferedReader.readLine();
            processExec.destroy();
            try {
                bufferedReader.close();
            } catch (Throwable unused2) {
            }
            return line;
        } catch (Throwable unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable unused4) {
                }
            }
            return line;
        }
    }

    public static final G8.b h(String str) {
        G8.c cVar = G8.i.f693a;
        return new G8.b(G8.i.f693a, G8.f.e(str));
    }

    public static final G8.b i(String str) {
        G8.c cVar = G8.i.f693a;
        return new G8.b(G8.i.c, G8.f.e(str));
    }

    public static final LinkedHashMap j(LinkedHashMap linkedHashMap) {
        Set<Map.Entry> setEntrySet = linkedHashMap.entrySet();
        int iP = kotlin.collections.a.P(w.c0(setEntrySet, 10));
        if (iP < 16) {
            iP = 16;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(iP);
        for (Map.Entry entry : setEntrySet) {
            linkedHashMap2.put(entry.getValue(), entry.getKey());
        }
        return linkedHashMap2;
    }

    public static final boolean k(String str) {
        for (int i6 = 0; i6 < str.length(); i6++) {
            char cCharAt = str.charAt(i6);
            if (kotlin.jvm.internal.k.g(cCharAt, 128) >= 0 || Character.isLetter(cCharAt)) {
                return true;
            }
        }
        return false;
    }

    public static final G8.b l(G8.f fVar) {
        G8.c cVar = G8.i.f693a;
        G8.b bVar = G8.i.m;
        return new G8.b(bVar.f687a, G8.f.e(fVar.c().concat(bVar.f().c())));
    }

    public static final G8.b m(String str) {
        G8.c cVar = G8.i.f693a;
        return new G8.b(G8.i.b, G8.f.e(str));
    }

    public static final G8.b n(G8.b bVar) {
        G8.c cVar = G8.i.f693a;
        return new G8.b(G8.i.f693a, G8.f.e("U".concat(bVar.f().c())));
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.Map] */
    public static String o(String appName, Map map) {
        kotlin.jvm.internal.k.f(appName, "appName");
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            Locale locale = Locale.ROOT;
            String lowerCase = str.toLowerCase(locale);
            kotlin.jvm.internal.k.e(lowerCase, "toLowerCase(...)");
            String lowerCase2 = appName.toLowerCase(locale);
            kotlin.jvm.internal.k.e(lowerCase2, "toLowerCase(...)");
            if (lowerCase.equals(lowerCase2) && str2.length() > 0) {
                return str2;
            }
        }
        String str3 = (String) Ia.b.f856a.get(appName);
        return str3 == null ? appName : str3;
    }

    public static String p(int i6) {
        switch (i6) {
            case 1:
                return "EXIT_SELF";
            case 2:
                return "SIGNALED";
            case 3:
                return "LOW_MEMORY";
            case 4:
                return "APP CRASH(EXCEPTION)";
            case 5:
                return "APP CRASH(NATIVE)";
            case 6:
                return "ANR";
            case 7:
                return "INITIALIZATION FAILURE";
            case 8:
                return "PERMISSION CHANGE";
            case 9:
                return "EXCESSIVE RESOURCE USAGE";
            case 10:
                return "USER REQUESTED";
            case 11:
                return "USER STOPPED";
            case 12:
                return "DEPENDENCY DIED";
            case 13:
                return "OTHER KILLS BY SYSTEM";
            case 14:
                return "FREEZER";
            default:
                return "UNKNOWN";
        }
    }

    public static String q(int i6) {
        switch (i6) {
            case 1:
                return "WAIT FOR DEBUGGER";
            case 2:
                return "TOO MANY CACHED PROCS";
            case 3:
                return "TOO MANY EMPTY PROCS";
            case 4:
                return "TRIM EMPTY";
            case 5:
                return "LARGE CACHED";
            case 6:
                return "MEMORY PRESSURE";
            case 7:
                return "EXCESSIVE CPU USAGE";
            case 8:
                return "SYSTEM UPDATE_DONE";
            case 9:
                return "KILL ALL FG";
            case 10:
                return "KILL ALL BG EXCEPT";
            case 11:
                return "KILL UID";
            case 12:
                return "KILL PID";
            case 13:
                return "INVALID START";
            case 14:
                return "INVALID STATE";
            case 15:
                return "IMPERCEPTIBLE";
            case 16:
                return "REMOVE LRU";
            case 17:
                return "ISOLATED NOT NEEDED";
            case 18:
                return "CACHED IDLE FORCED APP STANDBY";
            case 19:
                return "FREEZER BINDER IOCTL";
            case 20:
                return "FREEZER BINDER TRANSACTION";
            case 21:
                return "FORCE STOP";
            case 22:
                return "REMOVE TASK";
            case 23:
                return "STOP APP";
            case 24:
                return "KILL BACKGROUND";
            case 25:
                return "PACKAGE UPDATE";
            default:
                return "UNKNOWN";
        }
    }

    public static void r(Class cls, Object obj) {
        if (obj != null) {
            return;
        }
        throw new IllegalStateException(cls.getCanonicalName() + " must be set");
    }

    public static final void s(AutoCloseable autoCloseable, Throwable th) {
        boolean zIsTerminated;
        if (autoCloseable != null) {
            if (th != null) {
                try {
                    androidx.constraintlayout.core.dsl.a.r(autoCloseable);
                    return;
                } catch (Throwable th2) {
                    S0.b.e0(th, th2);
                    return;
                }
            }
            if (autoCloseable instanceof AutoCloseable) {
                autoCloseable.close();
                return;
            }
            if (!(autoCloseable instanceof ExecutorService)) {
                throw new IllegalArgumentException();
            }
            ExecutorService executorService = (ExecutorService) autoCloseable;
            if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
                return;
            }
            executorService.shutdown();
            boolean z10 = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z10) {
                        executorService.shutdownNow();
                        z10 = true;
                    }
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String t(h8.InterfaceC1536s r6, int r7) {
        /*
            r0 = r7 & 1
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L8
            r0 = r2
            goto L9
        L8:
            r0 = r1
        L9:
            r7 = r7 & 2
            if (r7 == 0) goto Le
            r1 = r2
        Le:
            java.lang.String r7 = "<this>"
            kotlin.jvm.internal.k.f(r6, r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            if (r1 == 0) goto L34
            boolean r1 = r6 instanceof h8.InterfaceC1526i
            if (r1 == 0) goto L21
            java.lang.String r1 = "<init>"
            goto L31
        L21:
            r1 = r6
            k8.m r1 = (k8.AbstractC1644m) r1
            G8.f r1 = r1.getName()
            java.lang.String r1 = r1.b()
            java.lang.String r2 = "asString(...)"
            kotlin.jvm.internal.k.e(r1, r2)
        L31:
            r7.append(r1)
        L34:
            java.lang.String r1 = "("
            r7.append(r1)
            k8.u r1 = r6.I()
            g9.c r2 = g9.c.f4501a
            java.lang.String r3 = "getType(...)"
            if (r1 == 0) goto L55
            X8.w r1 = r1.getType()
            kotlin.jvm.internal.k.e(r1, r3)
            z8.t r4 = z8.t.k
            java.lang.Object r1 = U7.a.O(r1, r4, r2)
            z8.m r1 = (z8.m) r1
            r7.append(r1)
        L55:
            java.util.List r1 = r6.x()
            java.util.Iterator r1 = r1.iterator()
        L5d:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L7e
            java.lang.Object r4 = r1.next()
            k8.Q r4 = (k8.Q) r4
            k8.S r4 = (k8.S) r4
            X8.w r4 = r4.getType()
            kotlin.jvm.internal.k.e(r4, r3)
            z8.t r5 = z8.t.k
            java.lang.Object r4 = U7.a.O(r4, r5, r2)
            z8.m r4 = (z8.m) r4
            r7.append(r4)
            goto L5d
        L7e:
            java.lang.String r1 = ")"
            r7.append(r1)
            if (r0 == 0) goto Lc4
            boolean r0 = r6 instanceof h8.InterfaceC1526i
            if (r0 == 0) goto L8a
            goto Lac
        L8a:
            X8.w r0 = r6.getReturnType()
            kotlin.jvm.internal.k.c(r0)
            G8.f r1 = e8.i.e
            G8.e r1 = e8.n.d
            boolean r0 = e8.i.D(r0, r1)
            if (r0 == 0) goto Lb2
            X8.w r0 = r6.getReturnType()
            kotlin.jvm.internal.k.c(r0)
            boolean r0 = X8.S.e(r0)
            if (r0 != 0) goto Lb2
            boolean r0 = r6 instanceof k8.I
            if (r0 != 0) goto Lb2
        Lac:
            java.lang.String r6 = "V"
            r7.append(r6)
            goto Lc4
        Lb2:
            X8.w r6 = r6.getReturnType()
            kotlin.jvm.internal.k.c(r6)
            z8.t r0 = z8.t.k
            java.lang.Object r6 = U7.a.O(r6, r0, r2)
            z8.m r6 = (z8.m) r6
            r7.append(r6)
        Lc4:
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "toString(...)"
            kotlin.jvm.internal.k.e(r6, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.task.executor.e.t(h8.s, int):java.lang.String");
    }

    public static final String u(InterfaceC1519b interfaceC1519b) {
        kotlin.jvm.internal.k.f(interfaceC1519b, "<this>");
        if (!J8.e.o(interfaceC1519b)) {
            InterfaceC1527j interfaceC1527jD = interfaceC1519b.d();
            InterfaceC1522e interfaceC1522e = interfaceC1527jD instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1527jD : null;
            if (interfaceC1522e != null && !interfaceC1522e.getName().b) {
                InterfaceC1519b interfaceC1519bA = interfaceC1519b.a();
                K k5 = interfaceC1519bA instanceof K ? (K) interfaceC1519bA : null;
                if (k5 != null) {
                    return AbstractC0897f.K(interfaceC1522e, t(k5, 3));
                }
            }
        }
        return null;
    }

    public static void v(Application application, S7.k kVar) {
        kotlin.jvm.internal.k.f(application, "application");
        l = application;
        Log.d("TaskRobotManager", "connectRemote " + k);
        if (k != null) {
            if (kVar != null) {
                kVar.invoke(Boolean.TRUE);
            }
        } else {
            Log.d("TaskRobotManager", "connectRemote");
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.stepos.ability", "com.stepos.taskrobot.service.TaskRobotService"));
            application.bindService(intent, new n6.c(kVar), 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004c A[Catch: all -> 0x0066, TryCatch #1 {all -> 0x0066, blocks: (B:3:0x000a, B:10:0x002a, B:12:0x0043, B:13:0x0046, B:15:0x004c, B:17:0x0050, B:18:0x0060, B:20:0x0062, B:21:0x0065), top: B:37:0x000a, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0050 A[Catch: all -> 0x0066, TryCatch #1 {all -> 0x0066, blocks: (B:3:0x000a, B:10:0x002a, B:12:0x0043, B:13:0x0046, B:15:0x004c, B:17:0x0050, B:18:0x0060, B:20:0x0062, B:21:0x0065), top: B:37:0x000a, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static U8.b w(G8.c r7, W8.i r8, h8.InterfaceC1540w r9, java.io.InputStream r10) throws java.io.IOException {
        /*
            java.lang.String r0 = "fqName"
            kotlin.jvm.internal.k.f(r7, r0)
            java.lang.String r0 = "module"
            kotlin.jvm.internal.k.f(r9, r0)
            C8.a r0 = C8.a.f     // Catch: java.lang.Throwable -> L66
            C8.a r6 = a.AbstractC0291a.B(r10)     // Catch: java.lang.Throwable -> L66
            C8.a r0 = C8.a.f     // Catch: java.lang.Throwable -> L66
            int r1 = r6.c     // Catch: java.lang.Throwable -> L66
            java.lang.String r2 = "ourVersion"
            kotlin.jvm.internal.k.f(r0, r2)     // Catch: java.lang.Throwable -> L66
            int r2 = r0.c     // Catch: java.lang.Throwable -> L66
            int r3 = r0.b     // Catch: java.lang.Throwable -> L66
            int r4 = r6.b     // Catch: java.lang.Throwable -> L66
            if (r4 != 0) goto L26
            if (r3 != 0) goto L69
            if (r1 != r2) goto L69
            goto L2a
        L26:
            if (r4 != r3) goto L69
            if (r1 > r2) goto L69
        L2a:
            H8.h r1 = new H8.h     // Catch: java.lang.Throwable -> L66
            r1.<init>()     // Catch: java.lang.Throwable -> L66
            C8.b.a(r1)     // Catch: java.lang.Throwable -> L66
            B8.a r2 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment.k     // Catch: java.lang.Throwable -> L66
            r2.getClass()     // Catch: java.lang.Throwable -> L66
            H8.f r3 = new H8.f     // Catch: java.lang.Throwable -> L66
            r3.<init>(r10)     // Catch: java.lang.Throwable -> L66
            java.lang.Object r1 = r2.a(r3, r1)     // Catch: java.lang.Throwable -> L66
            H8.b r1 = (H8.AbstractC0241b) r1     // Catch: java.lang.Throwable -> L66
            r2 = 0
            r3.a(r2)     // Catch: kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L61 java.lang.Throwable -> L66
            boolean r2 = r1.isInitialized()     // Catch: java.lang.Throwable -> L66
            if (r2 == 0) goto L50
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment r1 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment) r1     // Catch: java.lang.Throwable -> L66
        L4e:
            r5 = r1
            goto L6b
        L50:
            kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException r7 = new kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException     // Catch: java.lang.Throwable -> L66
            r7.<init>()     // Catch: java.lang.Throwable -> L66
            kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException r8 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L66
            java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Throwable -> L66
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L66
            r8.f5100a = r1     // Catch: java.lang.Throwable -> L66
            throw r8     // Catch: java.lang.Throwable -> L66
        L61:
            r0 = move-exception
            r7 = r0
            r7.f5100a = r1     // Catch: java.lang.Throwable -> L66
            throw r7     // Catch: java.lang.Throwable -> L66
        L66:
            r0 = move-exception
            r7 = r0
            goto L9a
        L69:
            r1 = 0
            goto L4e
        L6b:
            r10.close()
            if (r5 == 0) goto L79
            U8.b r1 = new U8.b
            r2 = r7
            r3 = r8
            r4 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            return r1
        L79:
            java.lang.UnsupportedOperationException r7 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Kotlin built-in definition format version is not supported: expected "
            r8.<init>(r9)
            r8.append(r0)
            java.lang.String r9 = ", actual "
            r8.append(r9)
            r8.append(r6)
            java.lang.String r9 = ". Please update Kotlin"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L9a:
            throw r7     // Catch: java.lang.Throwable -> L9b
        L9b:
            r0 = move-exception
            r8 = r0
            D7.N.t(r10, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.task.executor.e.w(G8.c, W8.i, h8.w, java.io.InputStream):U8.b");
    }

    public static boolean x(int i6) {
        return i6 == 10 || i6 == 11;
    }

    public static AccessibilityNodeInfo y(AccessibilityNodeInfo accessibilityNodeInfo, C2016a c2016a) {
        try {
            if (((Boolean) c2016a.invoke(accessibilityNodeInfo)).booleanValue()) {
                return accessibilityNodeInfo;
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i6);
                if (child != null) {
                    try {
                        AccessibilityNodeInfo accessibilityNodeInfoY = y(child, c2016a);
                        if (accessibilityNodeInfoY != null) {
                        }
                        if (!child.equals(accessibilityNodeInfo)) {
                            child.recycle();
                        }
                    } finally {
                        if (!child.equals(accessibilityNodeInfo)) {
                            child.recycle();
                        }
                    }
                }
            }
            return null;
        } catch (Exception e6) {
            com.stepos.statsrpk.service.c.n("Error in findNode: ", e6.getMessage(), "NodeFinder");
            return null;
        }
    }

    public static MixedContent z(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(AgentBusWakeContract.EXTRA_SOURCE);
        if (bundle2 == null) {
            throw new IllegalArgumentException("MultiImageBundle missing 'source'");
        }
        Bundle bundle3 = bundle.getBundle(InpaintImageAction.IMAGES_KEY_MASK);
        ArrayList arrayList = new ArrayList();
        Content contentA = A(bundle2);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("role", new d5.k(AgentBusWakeContract.EXTRA_SOURCE));
        kotlin.jvm.internal.e eVar = null;
        contentA.setParams(new ContentParams(kotlin.collections.a.Y(linkedHashMap), eVar));
        arrayList.add(contentA);
        if (bundle3 != null) {
            Content contentA2 = A(bundle3);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("role", new d5.k(InpaintImageAction.IMAGES_KEY_MASK));
            contentA2.setParams(new ContentParams(kotlin.collections.a.Y(linkedHashMap2), eVar));
            arrayList.add(contentA2);
        }
        return new MixedContent(arrayList);
    }
}
