package com.obric.oui.constraintlayout.core.motion.utils;

import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.util.HanziToPinyin;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class Utils {
    static DebugHandle sOurHandle;

    public interface DebugHandle {
        void message(String r1);
    }

    private static int clamp(int r1) {
        int r2 = (r1 & (~(r1 >> 31))) - 255;
        return (r2 & (r2 >> 31)) + 255;
    }

    public Utils() {
    }

    public static void log(String r2, String r3) {
        System.out.println(r2 + " : " + r3);
    }

    public static void loge(String r2, String r3) {
        System.err.println(r2 + " : " + r3);
    }

    public static void socketSend(String r4) {
        OutputStream r0 = new Socket("127.0.0.1", 5327).getOutputStream();     // Catch: IOException -> L4
        r0.write(r4.getBytes());     // Catch: IOException -> L4
        r0.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace("[", "   at ").replace(SimContactsConstants.EMAIL_SEP, "\n   at").replace("]", ""));
    }

    public int getInterpolatedColor(float[] r7) {
        int r6 = clamp((int) (((float) Math.pow(r7[0], 0.45454545454545453d)) * 255.0f));
        int r1 = clamp((int) (((float) Math.pow(r7[1], 0.45454545454545453d)) * 255.0f));
        return (((r6 << 16) | (clamp((int) (r7[3] * 255.0f)) << 24)) | (r1 << 8)) | clamp((int) (((float) Math.pow(r7[2], 0.45454545454545453d)) * 255.0f));
    }

    public static int rgbaTocColor(float r1, float r2, float r3, float r4) {
        int r5 = clamp((int) (r1 * 255.0f));
        int r6 = clamp((int) (r2 * 255.0f));
        int r7 = clamp((int) (r3 * 255.0f));
        int r8 = r5 << 16;
        return ((r8 | (clamp((int) (r4 * 255.0f)) << 24)) | (r6 << 8)) | r7;
    }

    public static void setDebugHandle(DebugHandle r0) {
        sOurHandle = r0;
    }

    public static void logStack(String r7, int r8) {
        StackTraceElement[] r0 = new Throwable().getStackTrace();
        int r2 = 1;
        int r9 = Math.min(r8, r0.length - 1);
        String r3 = HanziToPinyin.Token.SEPARATOR;
    L3:
        if (r2 > r9) goto L5;
        StackTraceElement r4 = r0[r2];
        String r5 = ".(" + r4.getFileName() + SimContactsConstants.ANR_SEP + r4.getLineNumber() + ") " + r4.getMethodName();
        r3 = r3 + HanziToPinyin.Token.SEPARATOR;
        System.out.println(r7 + r3 + r5 + r3);
        r2 = r2 + 1;
        goto L3
    }

    public static void log(String r5) {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        String r1 = (r0.getMethodName() + "                  ").substring(0, 17);
        String r2 = ".(" + r0.getFileName() + SimContactsConstants.ANR_SEP + r0.getLineNumber() + ")" + "    ".substring(Integer.toString(r0.getLineNumber()).length()) + r1;
        System.out.println(r2 + HanziToPinyin.Token.SEPARATOR + r5);
        DebugHandle r3 = sOurHandle;
        if (r3 == null) goto L6;
        r3.message(r2 + HanziToPinyin.Token.SEPARATOR + r5);
        return;
    }
}
