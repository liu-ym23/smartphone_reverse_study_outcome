package com.stepos.pps.data.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class SysInfoUtils {
    private static final String TAG = "SysInfoUtils";

    public static int getRunMemorySizeGB() throws IOException {
        String str = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            str = bufferedReader.readLine().split("\\s+")[1];
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str == null) {
            return 0;
        }
        int iCeil = (int) Math.ceil(Float.parseFloat(str) / 1000000.0f);
        if (iCeil > 16) {
            return 16;
        }
        return iCeil;
    }
}
