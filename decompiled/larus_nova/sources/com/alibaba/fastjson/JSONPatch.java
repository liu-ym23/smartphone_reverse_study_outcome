package com.alibaba.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public class JSONPatch {

    /* JADX INFO: renamed from: com.alibaba.fastjson.JSONPatch$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType = null;

        static {
            int[] r100 = new int[OperationType.values().length];
            $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType = r100;
            r100[OperationType.add.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType[OperationType.replace.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType[OperationType.remove.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType[OperationType.copy.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType[OperationType.move.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType[OperationType.test.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    @JSONType(orders = {"op", "from", "path", "value"})
    public static class Operation {
        public String from;
        public String path;

        @JSONField(name = "op")
        public OperationType type;
        public Object value;

        public Operation() {
        }
    }

    public static final enum OperationType extends Enum<OperationType> {
        private static final /* synthetic */ OperationType[] $VALUES = null;
        public static final OperationType add = null;
        public static final OperationType copy = null;
        public static final OperationType move = null;
        public static final OperationType remove = null;
        public static final OperationType replace = null;
        public static final OperationType test = null;

        static {
            OperationType r100 = new OperationType("add", 0);
            add = r100;
            OperationType r101 = new OperationType("remove", 1);
            remove = r101;
            OperationType r102 = new OperationType("replace", 2);
            replace = r102;
            OperationType r103 = new OperationType("move", 3);
            move = r103;
            OperationType r104 = new OperationType("copy", 4);
            copy = r104;
            OperationType r105 = new OperationType(EffectConstants.CHANNEL_TEST, 5);
            test = r105;
            $VALUES = new OperationType[]{r100, r101, r102, r103, r104, r105};
        }

        public static OperationType[] values() {
            return (OperationType[]) $VALUES.clone();
        }

        public static OperationType valueOf(String r100) {
            return (OperationType) a.a(OperationType.class, r100);
        }

        private OperationType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public JSONPatch() {
    }

    private static boolean isObject(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = 0;
    L7:
        if (r101 >= r100.length()) goto L18;
        char r102 = r100.charAt(r101);
        if (JSONLexerBase.isWhitespace(r102) == false) goto L12;
        r101 = r101 + 1;
        goto L7
    L12:
        if (r102 != '{') goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public static Object apply(Object r110, String r111) {
        boolean r100 = false;
        if (isObject(r111) == false) goto L5;
        Operation[] r101 = {(Operation) JSON.parseObject(r111, Operation.class)};
    L6:
        int r112 = r101.length;
        int r102 = 0;
    L7:
        if (r102 >= r112) goto L32;
        Operation r103 = r101[r102];
        JSONPath r104 = JSONPath.compile(r103.path);
        switch(AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPatch$OperationType[r103.type.ordinal()]) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L20;
            case 5: goto L20;
            case 6: goto L11;
            default: goto L31;
        };
    L20:
        JSONPath r105 = JSONPath.compile(r103.from);
        Object r106 = r105.eval(r110);
        if (r103.type == OperationType.move) goto L23;
    L27:
        r104.set(r110, r106);
        goto L31
    L23:
        if (r105.remove(r110) == true) goto L27;
        throw new JSONException("json patch move error : " + r103.from + " -> " + r103.path);
    L28:
        r104.remove(r110);
        goto L31
    L29:
        r104.patchAdd(r110, r103.value, true);
        goto L31
    L30:
        r104.patchAdd(r110, r103.value, false);
        goto L31
    L11:
        Object r113 = r104.eval(r110);
        if (r113 != null) goto L19;
        if (r103.value != null) goto L17;
        r100 = true;
    L17:
        return Boolean.valueOf(r100);
    L19:
        return Boolean.valueOf(r113.equals(r103.value));
    L31:
        r102 = r102 + 1;
        goto L7
    L32:
        return r110;
    L5:
        r101 = (Operation[]) JSON.parseObject(r111, Operation[].class);
        goto L6
    }

    public static String apply(String r100, String r101) {
        return JSON.toJSONString(apply(JSON.parse(r100, new Feature[]{Feature.OrderedField}), r101));
    }
}
