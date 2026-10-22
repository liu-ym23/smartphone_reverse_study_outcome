package com.android.server.pm;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.ArraySet;
import dalvik.system.VMRuntime;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class InstructionSets {
    private static final String PREFERRED_INSTRUCTION_SET = null;

    public InstructionSets() {
    }

    static {
        PREFERRED_INSTRUCTION_SET = VMRuntime.getInstructionSet(Build.SUPPORTED_ABIS[0]);
    }

    public static String[] getAppDexInstructionSets(String primaryCpuAbi, String secondaryCpuAbi) {
        if (primaryCpuAbi == null) goto L9;
        if (secondaryCpuAbi == null) goto L7;
        return new String[]{VMRuntime.getInstructionSet(primaryCpuAbi), VMRuntime.getInstructionSet(secondaryCpuAbi)};
    L7:
        return new String[]{VMRuntime.getInstructionSet(primaryCpuAbi)};
    L9:
        return new String[]{getPreferredInstructionSet()};
    }

    public static String getPreferredInstructionSet() {
        return PREFERRED_INSTRUCTION_SET;
    }

    public static String getDexCodeInstructionSet(String sharedLibraryIsa) {
        String dexCodeIsa = SystemProperties.get("ro.dalvik.vm.isa." + sharedLibraryIsa);
        if (TextUtils.isEmpty(dexCodeIsa) == false) goto L6;
        return sharedLibraryIsa;
    L6:
        return dexCodeIsa;
    }

    public static String[] getDexCodeInstructionSets(String[] instructionSets) {
        ArraySet<String> dexCodeInstructionSets = new ArraySet(instructionSets.length);
        int r1 = instructionSets.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        String instructionSet = instructionSets[r2];
        dexCodeInstructionSets.add(getDexCodeInstructionSet(instructionSet));
        r2 = r2 + 1;
        goto L3
    L6:
        return (String[]) dexCodeInstructionSets.toArray(new String[dexCodeInstructionSets.size()]);
    }

    public static String[] getAllDexCodeInstructionSets() {
        String[] supportedInstructionSets = new String[Build.SUPPORTED_ABIS.length];
        int i = 0;
    L4:
        if (i >= supportedInstructionSets.length) goto L7;
        String abi = Build.SUPPORTED_ABIS[i];
        supportedInstructionSets[i] = VMRuntime.getInstructionSet(abi);
        i = i + 1;
        goto L4
    L7:
        return getDexCodeInstructionSets(supportedInstructionSets);
    }

    public static List<String> getAllInstructionSets() {
        String[] allAbis = Build.SUPPORTED_ABIS;
        List<String> allInstructionSets = new ArrayList(allAbis.length);
        int r2 = allAbis.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        String abi = allAbis[r3];
        String instructionSet = VMRuntime.getInstructionSet(abi);
        if (allInstructionSets.contains(instructionSet) == true) goto L7;
        allInstructionSets.add(instructionSet);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        return allInstructionSets;
    }

    public static String getPrimaryInstructionSet(PackageAbiHelper.Abis abis) {
        if (abis.primary != null) goto L7;
        return getPreferredInstructionSet();
    L7:
        return VMRuntime.getInstructionSet(abis.primary);
    }
}
