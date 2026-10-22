package com.alibaba.fastjson.asm;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.ASMUtils;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import java.lang.reflect.Modifier;
import java.util.Map;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes28.dex */
public class TypeCollector {
    private static String JSONType;
    private static final Map<String, String> primitives = null;
    protected MethodCollector collector;
    protected boolean jsonType;
    private final String methodName;
    private final Class<?>[] parameterTypes;

    static {
        JSONType = ASMUtils.desc(JSONType.class);
        primitives = new AnonymousClass1();
    }

    public String[] getParameterNamesForMethod() {
        MethodCollector r100 = this.collector;
        if (r100 == null) goto L10;
        if (r100.debugInfoPresent == false) goto L10;
        return r100.getResult().split(",");
    L10:
        return new String[0];
    }

    public boolean matched() {
        if (this.collector == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasJsonType() {
        return this.jsonType;
    }

    public void visitAnnotation(String r100) {
        if (JSONType.equals(r100) == false) goto L6;
        this.jsonType = true;
        return;
    }

    public TypeCollector(String r100, Class<?>[] r101) {
        this.methodName = r100;
        this.parameterTypes = r101;
        this.collector = null;
    }

    private boolean correctTypeName(Type r100, String r101) {
        String r102 = r100.getClassName();
        StringBuilder r103 = new StringBuilder();
    L4:
        if (r102.endsWith("[]") == false) goto L7;
        r103.append('[');
        r102 = r102.substring(0, r102.length() - 2);
        goto L4
    L7:
        if (r103.length() == 0) goto L13;
        Map<String, String> r104 = primitives;
        if (r104.containsKey(r102) == false) goto L11;
        r103.append(r104.get(r102));
        r102 = r103.toString();
        goto L13
    L11:
        r103.append(Matrix.MATRIX_TYPE_RANDOM_LT);
        r103.append(r102);
        r103.append(';');
        r102 = r103.toString();
    L13:
        return r102.equals(r101);
    }

    public MethodCollector visitMethod(int r100, String r101, String r102) {
        if (this.collector == null) goto L6;
        return null;
    L6:
        if (r101.equals(this.methodName) == true) goto L8;
        return null;
    L8:
        Type[] r103 = Type.getArgumentTypes(r102);
        int r104 = r103.length;
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
    L9:
        if (r106 >= r104) goto L17;
        String r108 = r103[r106].getClassName();
        if (r108.equals("long") == false) goto L13;
    L14:
        r107 = r107 + 1;
    L15:
        r106 = r106 + 1;
        goto L9
    L13:
        if (r108.equals(ItemStyle.ITEM_STYLE_DOUBLE) == false) goto L15;
    L17:
        if (r103.length == this.parameterTypes.length) goto L20;
        return null;
    L20:
        if (r105 >= r103.length) goto L25;
        if (correctTypeName(r103[r105], this.parameterTypes[r105].getName()) == false) goto L23;
        r105 = r105 + 1;
        goto L20
    L23:
        return null;
    L25:
        MethodCollector r109 = new MethodCollector(!Modifier.isStatic(r100) ? 1 : 0, r103.length + r107);
        this.collector = r109;
        return r109;
    }
}
