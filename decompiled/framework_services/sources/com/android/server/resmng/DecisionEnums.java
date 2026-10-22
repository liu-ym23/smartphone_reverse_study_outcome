package com.android.server.resmng;

import com.android.server.am.IApplicationFreezer;
import com.android.server.am.ProcessRecord;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DecisionEnums {
    public static final int DECISION_OUTPUT_INVALID = -1;
    public static final String FEATURE_NAME = "decision_rule";
    public static final int FREEZE_ACTION_FREEZE = 1;
    public static final int FREEZE_ACTION_NONE = 0;
    public static final int KILL_ACTION_FORCE_STOP = 12;
    public static final int KILL_ACTION_FORCE_STOP_BG = 13;
    public static final int KILL_ACTION_KILL = 11;
    public static final int KILL_ACTION_NONE = 10;
    public static final int KILL_ACTION_THREAD_OVERLIMIT = 14;
    public static final int NF_POWER_ACTION_FORCE_STOP = 22;
    public static final int NF_POWER_ACTION_KILL_UID = 21;
    public static final int NF_POWER_ACTION_NONE = 20;

    public static final enum ActionType extends Enum<ActionType> {
        private static final /* synthetic */ ActionType[] $VALUES = null;
        public static final ActionType FREEZE = null;
        public static final ActionType KILL = null;
        public static final ActionType KILL_RANK = null;
        public static final ActionType NF_POWER_KILL = null;
        private String name;

        private static /* synthetic */ ActionType[] $values() {
            return new ActionType[]{FREEZE, KILL_RANK, NF_POWER_KILL, KILL};
        }

        public static ActionType valueOf(String name) {
            return (ActionType) Enum.valueOf(ActionType.class, name);
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }

        static {
            FREEZE = new ActionType("FREEZE", 0, IResMngConfig.FEAT_FREEZE);
            KILL_RANK = new ActionType("KILL_RANK", 1, "kill_rank");
            NF_POWER_KILL = new ActionType("NF_POWER_KILL", 2, "nf_power_kill");
            KILL = new ActionType("KILL", 3, "kill");
            $VALUES = $values();
        }

        private ActionType(String r1, int r2, String name) {
            super(r1, r2);
            this.name = name;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }

        public static ActionType fromString(String name) {
            ActionType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            ActionType type = r0[r2];
            if (type.name.equals(name) == true) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return type;
        L8:
            return null;
        }
    }

    public static class DecisionInput {
        public ActionType[] actionTypes;
        public ModuleType moduleType;
        public Object obj;
        public String pkg;
        public ProcessRecord r;
        public int uid;

        public DecisionInput(ModuleType moduleType, ProcessRecord r, ActionType[] actionTypes) {
            this.moduleType = moduleType;
            this.actionTypes = actionTypes;
            this.r = r;
        }

        public DecisionInput(ModuleType moduleType, int uid, String pkg, ProcessRecord r, ActionType[] actionTypes) {
            this.uid = uid;
            this.pkg = pkg;
            this.moduleType = moduleType;
            this.actionTypes = actionTypes;
            this.r = r;
        }

        public String toString() {
            return "DecisionInput: {moduleType: " + this.moduleType + ", actionTypes: " + Arrays.toString(this.actionTypes) + ", uid: " + this.uid + ", pkg: " + this.pkg + ", r: " + this.r + "}";
        }
    }

    public static class DecisionOutput {
        public int[] actionValues;
        public String reason;

        public DecisionOutput() {
        }

        public String toString() {
            return "DecisionOutput: {action: " + Arrays.toString(this.actionValues) + ", reason: " + this.reason + "}";
        }

        public boolean valid() {
            if (this.actionValues != null) goto L5;
        L7:
            return false;
        L5:
            if (this.actionValues.length <= 0) goto L7;
            return true;
        }
    }

    public static final enum HabbitType extends Enum<HabbitType> {
        private static final /* synthetic */ HabbitType[] $VALUES = null;
        public static final HabbitType DAILY_TOPN = null;
        public static final HabbitType RECENT = null;
        private final String habbitType;

        private static /* synthetic */ HabbitType[] $values() {
            return new HabbitType[]{DAILY_TOPN, RECENT};
        }

        public static HabbitType valueOf(String name) {
            return (HabbitType) Enum.valueOf(HabbitType.class, name);
        }

        public static HabbitType[] values() {
            return (HabbitType[]) $VALUES.clone();
        }

        static {
            DAILY_TOPN = new HabbitType("DAILY_TOPN", 0, "daily_topn");
            RECENT = new HabbitType("RECENT", 1, "recent");
            $VALUES = $values();
        }

        private HabbitType(String r1, int r2, String habbitType) {
            super(r1, r2);
            this.habbitType = habbitType;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.habbitType;
        }
    }

    public static final enum ModuleType extends Enum<ModuleType> {
        private static final /* synthetic */ ModuleType[] $VALUES = null;
        public static final ModuleType AUTO_FREEZE = null;
        public static final ModuleType CAMERA_SCENE_FREEZE = null;
        public static final ModuleType CPU_BUSY = null;
        public static final ModuleType FREEZER = null;
        public static final ModuleType HIGH_TEMP_FREEZE = null;
        public static final ModuleType HIGH_TEMP_KILL = null;
        public static final ModuleType KILL = null;
        public static final ModuleType MEMORY_PROCESS_CONTROL = null;
        public static final ModuleType NF_POWER_KILL = null;
        public static final ModuleType POWER_FREEZE = null;
        public static final ModuleType QUICK_FREEZE = null;
        private static final Map<IApplicationFreezer.FreezeReason, ModuleType> REASON_TO_MODULE = null;
        public static final ModuleType THREAD_PROTECTOR = null;
        private final String moduleType;

        private static /* synthetic */ ModuleType[] $values() {
            return new ModuleType[]{FREEZER, QUICK_FREEZE, AUTO_FREEZE, POWER_FREEZE, HIGH_TEMP_FREEZE, CAMERA_SCENE_FREEZE, KILL, NF_POWER_KILL, HIGH_TEMP_KILL, MEMORY_PROCESS_CONTROL, CPU_BUSY, THREAD_PROTECTOR};
        }

        public static ModuleType valueOf(String name) {
            return (ModuleType) Enum.valueOf(ModuleType.class, name);
        }

        public static ModuleType[] values() {
            return (ModuleType[]) $VALUES.clone();
        }

        static {
            FREEZER = new ModuleType("FREEZER", 0, IResMngConfig.MOD_FREEZER);
            QUICK_FREEZE = new ModuleType("QUICK_FREEZE", 1, IResMngConfig.MOD_QUICK_FREEZE);
            AUTO_FREEZE = new ModuleType("AUTO_FREEZE", 2, IResMngConfig.MOD_AUTO_FREEZE);
            POWER_FREEZE = new ModuleType("POWER_FREEZE", 3, "power_freeze");
            HIGH_TEMP_FREEZE = new ModuleType("HIGH_TEMP_FREEZE", 4, IResMngConfig.MOD_HIGH_TEMP_FREEZE);
            CAMERA_SCENE_FREEZE = new ModuleType("CAMERA_SCENE_FREEZE", 5, "camera_scene_freeze");
            KILL = new ModuleType("KILL", 6, "kill");
            NF_POWER_KILL = new ModuleType("NF_POWER_KILL", 7, "nf_power_kill");
            HIGH_TEMP_KILL = new ModuleType("HIGH_TEMP_KILL", 8, "high_temp_kill");
            MEMORY_PROCESS_CONTROL = new ModuleType("MEMORY_PROCESS_CONTROL", 9, "memory_process_control");
            CPU_BUSY = new ModuleType("CPU_BUSY", 10, "cpu_busy");
            THREAD_PROTECTOR = new ModuleType("THREAD_PROTECTOR", 11, "thread_protector");
            $VALUES = $values();
            REASON_TO_MODULE = new HashMap();
            REASON_TO_MODULE.put(IApplicationFreezer.FreezeReason.POWER, POWER_FREEZE);
            REASON_TO_MODULE.put(IApplicationFreezer.FreezeReason.KEEP_ALIVE, MEMORY_PROCESS_CONTROL);
            REASON_TO_MODULE.put(IApplicationFreezer.FreezeReason.BUSY_BACKGROUND, CPU_BUSY);
            REASON_TO_MODULE.put(IApplicationFreezer.FreezeReason.LIGHTNING, QUICK_FREEZE);
            REASON_TO_MODULE.put(IApplicationFreezer.FreezeReason.CAMERA_SCENE, CAMERA_SCENE_FREEZE);
        }

        private ModuleType(String r1, int r2, String moduleType) {
            super(r1, r2);
            this.moduleType = moduleType;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.moduleType;
        }

        static ModuleType fromString(String moduleType) {
            ModuleType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            ModuleType type = r0[r2];
            if (type.toString().equals(moduleType) == true) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return type;
        L8:
            return null;
        }

        boolean compare(ModuleType type) {
            if (this != type) goto L4;
            return true;
        L4:
            return false;
        }

        public static ModuleType fromFreezeReason(IApplicationFreezer.FreezeReason reason) {
            if (reason != null) goto L6;
            return null;
        L6:
            if (REASON_TO_MODULE.containsKey(reason) == true) goto L8;
            return null;
        L8:
            return REASON_TO_MODULE.get(reason);
        }
    }

    public DecisionEnums() {
    }
}
