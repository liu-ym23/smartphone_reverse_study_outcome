package com.stepos.alphame.utils;

import android.os.Process;
import android.util.Log;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.AlphaMeServer;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.common.utils.LogKt;
import com.stepos.alphame.data.DataSource;
import com.stepos.alphame.data.DataSourceManager;
import com.stepos.alphame.engine.EngineBase;
import com.stepos.alphame.manager.ActionManager;
import com.stepos.alphame.manager.ActionRecord;
import com.stepos.alphame.sleep.SleepModeData;
import com.stepos.common.alphame.Args;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ServerDumper {
    private static final String TAG = "AlphaMe";
    private static boolean sEnableInvoke;

    private static byte[] byteArray(String str) {
        String[] strArrSplit = str.split(",");
        int length = strArrSplit.length;
        byte[] bArr = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            bArr[i4] = Byte.parseByte(strArrSplit[i4]);
        }
        return bArr;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v11, types: [java.lang.Byte] */
    /* JADX WARN: Type inference failed for: r13v14, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r13v17, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v21, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r1v5 */
    public static void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        byte b4;
        ?? ValueOf;
        int length = strArr == 0 ? 0 : strArr.length;
        if (length == 0) {
            printWriter.println("<!-- alphame.pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", userId=" + AlphaMeServer.getInstance().getMyUserId() + " -->\nUsage:adb shell dumpsys alphame_server [options]\n[options]\n  --all\n  --func\n  --action\n  --debug\n  --data [sourceTag]\n         [sourceTag]: AppClick/AppEvent/ScreenEvent/ActivityClick/SleepEvent\n  --broadcast [action] [value]\n         [action]: SCENE_CHANGED/SCREEN_EVENT/APP_EVENT/APP_LIST_CHANGED/APP_STATE_CHANGED/SYSTEM_STATE_CHANGED\n         [value]: boolean/byte/int/long/string/String[]/float类型参数");
        }
        String str = strArr[0];
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1628236621:
                if (str.equals("--debug")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1130481887:
                if (str.equals("--broadcast")) {
                    c4 = 1;
                    break;
                }
                break;
            case -199673127:
                if (str.equals("--collectAuthority")) {
                    c4 = 2;
                    break;
                }
                break;
            case 42995713:
                if (str.equals("--all")) {
                    c4 = 3;
                    break;
                }
                break;
            case 977062870:
                if (str.equals("--action")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1216320024:
                if (str.equals("--invoke")) {
                    c4 = 5;
                    break;
                }
                break;
            case 1332946250:
                if (str.equals("--data")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1333024868:
                if (str.equals("--func")) {
                    c4 = 7;
                    break;
                }
                break;
        }
        Object obj = null;
        switch (c4) {
            case 0:
                if (length <= 1) {
                    Utils.DEBUG.set(!r12.get());
                    LogKt.setDebugFlag(!LogKt.getDebugFlag().get());
                } else {
                    String str2 = strArr[1];
                    boolean z4 = "true".equalsIgnoreCase(str2) || "1".equals(str2);
                    Utils.DEBUG.set(z4);
                    LogKt.setDebugFlag(z4);
                }
                printWriter.println("set debug to " + Utils.DEBUG.get());
                break;
            case 1:
                if (length < 2) {
                    printWriter.println("Usage:adb shell dumpsys alphame_server --broadcast [action] [value]");
                    break;
                } else {
                    ActionRecord action = ActionManager.getInstance().getAction(strArr[1]);
                    if (action != null && (b4 = action.type) != 0 && strArr.length > 2) {
                        try {
                            if (b4 == 2) {
                                ValueOf = Boolean.valueOf(Boolean.parseBoolean(strArr[2]));
                            } else if (b4 == 4) {
                                ValueOf = Integer.valueOf(Integer.parseInt(strArr[2]));
                            } else if (b4 == 5) {
                                ValueOf = Long.valueOf(Long.parseLong(strArr[2]));
                            } else if (b4 == 3) {
                                ValueOf = Byte.valueOf(Byte.parseByte(strArr[2]));
                            } else if (b4 == 13) {
                                ValueOf = Float.valueOf(Float.parseFloat(strArr[2]));
                            } else if (b4 == 6) {
                                ValueOf = strArr[2];
                            } else if (b4 != 9) {
                                printWriter.println("请在ServerDumper支持类型：".concat(Args.k(b4)));
                                break;
                            } else {
                                ValueOf = new String[length - 2];
                                for (int i4 = 2; i4 < length; i4++) {
                                    ValueOf[i4 - 2] = strArr[i4];
                                }
                            }
                            obj = ValueOf;
                        } catch (Exception e4) {
                            AbstractC0351g.B("", e4, TAG);
                        }
                        ActionManager.getInstance().broadcast(action.action, obj);
                        break;
                    }
                }
                break;
            case 2:
                Utils.collectAuthority();
                break;
            case 3:
                EngineBase.dump(printWriter);
                printWriter.println("--------------------------------------------------------------------");
                ActionManager.getInstance().dump(printWriter);
                break;
            case 4:
                ActionManager.getInstance().dump(printWriter);
                break;
            case 5:
                handleInvoke(printWriter, strArr);
                break;
            case 6:
                String str3 = length > 1 ? strArr[1] : null;
                if (str3 == null) {
                    DataSourceManager.getInstance().dump(fileDescriptor, printWriter, strArr);
                    break;
                } else if ("SleepEvent".equals(str3)) {
                    SleepModeData.getInstance(ApplicationImpl.getApplication()).dump(printWriter);
                    break;
                } else {
                    DataSource dataSource = DataSourceManager.getInstance().getDataSource(str3);
                    if (dataSource != null) {
                        dataSource.dump(fileDescriptor, printWriter, strArr);
                        break;
                    }
                }
                break;
            case 7:
                EngineBase.dump(printWriter);
                break;
        }
    }

    public static void enableInvoke() {
        sEnableInvoke = true;
    }

    private static float[] floatArray(String str) {
        String[] strArrSplit = str.split(",");
        int length = strArrSplit.length;
        float[] fArr = new float[length];
        for (int i4 = 0; i4 < length; i4++) {
            fArr[i4] = Float.parseFloat(strArrSplit[i4]);
        }
        return fArr;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void handleInvoke(java.io.PrintWriter r13, java.lang.String[] r14) {
        /*
            Method dump skipped, instructions count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.utils.ServerDumper.handleInvoke(java.io.PrintWriter, java.lang.String[]):void");
    }

    private static int[] intArray(String str) {
        String[] strArrSplit = str.split(",");
        int length = strArrSplit.length;
        int[] iArr = new int[length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = Integer.parseInt(strArrSplit[i4]);
        }
        return iArr;
    }

    private static long[] longArray(String str) {
        String[] strArrSplit = str.split(",");
        int length = strArrSplit.length;
        long[] jArr = new long[length];
        for (int i4 = 0; i4 < length; i4++) {
            jArr[i4] = Long.parseLong(strArrSplit[i4]);
        }
        return jArr;
    }

    private static String stringOfResult(Object obj) {
        return obj instanceof int[] ? Arrays.toString((int[]) obj) : obj instanceof long[] ? Arrays.toString((long[]) obj) : obj instanceof byte[] ? Arrays.toString((byte[]) obj) : obj instanceof char[] ? Arrays.toString((char[]) obj) : obj instanceof float[] ? Arrays.toString((float[]) obj) : obj instanceof double[] ? Arrays.toString((double[]) obj) : obj instanceof String[] ? Arrays.toString((String[]) obj) : obj instanceof Object[] ? Arrays.toString((Object[]) obj) : obj.toString();
    }

    private static int[] intArray(String[] strArr) {
        int[] iArr = new int[strArr.length];
        for (int i4 = 0; i4 < strArr.length; i4++) {
            try {
                iArr[i4] = Integer.parseInt(strArr[i4]);
            } catch (Exception e4) {
                Log.w(TAG, "" + e4.getMessage());
            }
        }
        return iArr;
    }
}
