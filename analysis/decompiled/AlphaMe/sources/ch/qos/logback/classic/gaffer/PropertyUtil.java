package ch.qos.logback.classic.gaffer;

import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import java.beans.Introspector;
import java.lang.ref.SoftReference;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.BytecodeInterface8;
import org.codehaus.groovy.runtime.GStringImpl;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSite;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;
import org.codehaus.groovy.runtime.typehandling.DefaultTypeTransformation;

/* loaded from: classes.dex */
public class PropertyUtil implements GroovyObject {
    private static /* synthetic */ SoftReference $callSiteArray;
    private static /* synthetic */ ClassInfo $staticClassInfo;
    public static transient /* synthetic */ boolean __$stMC;
    public static /* synthetic */ long __timeStamp;
    public static /* synthetic */ long __timeStamp__239_neverHappen1396467705852;
    private transient /* synthetic */ MetaClass metaClass;

    class _upperCaseFirstLetter_closure1 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference $callSiteArray;
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        private static /* synthetic */ CallSiteArray $createCallSiteArray() {
            String[] strArr = new String[2];
            $createCallSiteArray_1(strArr);
            return new CallSiteArray(_upperCaseFirstLetter_closure1.class, strArr);
        }

        private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
            strArr[0] = "toUpperCase";
            strArr[1] = "doCall";
        }

        private static /* synthetic */ CallSite[] $getCallSiteArray() {
            CallSiteArray callSiteArray$createCallSiteArray;
            SoftReference softReference = $callSiteArray;
            if (softReference == null || (callSiteArray$createCallSiteArray = (CallSiteArray) softReference.get()) == null) {
                callSiteArray$createCallSiteArray = $createCallSiteArray();
                $callSiteArray = new SoftReference(callSiteArray$createCallSiteArray);
            }
            return callSiteArray$createCallSiteArray.array;
        }

        static {
            __$swapInit();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public _upperCaseFirstLetter_closure1(Object obj, Object obj2) {
            super(obj, obj2);
            $getCallSiteArray();
        }

        public static /* synthetic */ void __$swapInit() {
            $getCallSiteArray();
            $callSiteArray = null;
        }

        public static /* synthetic */ Class class$(String str) {
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e4) {
                throw new NoClassDefFoundError(e4.getMessage());
            }
        }

        public /* synthetic */ MetaClass $getStaticMetaClass() {
            if (getClass() != _upperCaseFirstLetter_closure1.class) {
                return ScriptBytecodeAdapter.initMetaClass(this);
            }
            ClassInfo classInfo = $staticClassInfo;
            if (classInfo == null) {
                classInfo = ClassInfo.getClassInfo(getClass());
                $staticClassInfo = classInfo;
            }
            return classInfo.getMetaClass();
        }

        public Object call(String str) {
            return $getCallSiteArray()[1].callCurrent(this, str);
        }

        public Object doCall(String str) {
            return $getCallSiteArray()[0].call(str);
        }
    }

    private static /* synthetic */ CallSiteArray $createCallSiteArray() {
        String[] strArr = new String[25];
        $createCallSiteArray_1(strArr);
        return new CallSiteArray(PropertyUtil.class, strArr);
    }

    private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
        strArr[0] = "upperCaseFirstLetter";
        strArr[1] = "respondsTo";
        strArr[2] = "metaClass";
        strArr[3] = "decapitalize";
        strArr[4] = "hasProperty";
        strArr[5] = "SINGLE";
        strArr[6] = "hasAdderMethod";
        strArr[7] = "AS_COLLECTION";
        strArr[8] = "NA";
        strArr[9] = "SINGLE";
        strArr[10] = "decapitalize";
        strArr[11] = "AS_COLLECTION";
        strArr[12] = "upperCaseFirstLetter";
        strArr[13] = "length";
        strArr[14] = "length";
        strArr[15] = "<$constructor$>";
        strArr[16] = "getAt";
        strArr[17] = "call";
        strArr[18] = "length";
        strArr[19] = "plus";
        strArr[20] = "substring";
        strArr[21] = "length";
        strArr[22] = "plus";
        strArr[23] = "substring";
        strArr[24] = "transformFirstLetter";
    }

    private static /* synthetic */ CallSite[] $getCallSiteArray() {
        CallSiteArray callSiteArray$createCallSiteArray;
        SoftReference softReference = $callSiteArray;
        if (softReference == null || (callSiteArray$createCallSiteArray = (CallSiteArray) softReference.get()) == null) {
            callSiteArray$createCallSiteArray = $createCallSiteArray();
            $callSiteArray = new SoftReference(callSiteArray$createCallSiteArray);
        }
        return callSiteArray$createCallSiteArray.array;
    }

    static {
        __$swapInit();
        __timeStamp__239_neverHappen1396467705852 = 0L;
        __timeStamp = 1396467705852L;
    }

    public PropertyUtil() {
        $getCallSiteArray();
        this.metaClass = $getStaticMetaClass();
    }

    public static /* synthetic */ void __$swapInit() {
        $getCallSiteArray();
        $callSiteArray = null;
    }

    public static void attach(NestingType nestingType, Object obj, Object obj2, String str) {
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        if (ScriptBytecodeAdapter.isCase(nestingType, callSiteArr$getCallSiteArray[9].callGetProperty(NestingType.class))) {
            ScriptBytecodeAdapter.setProperty(obj2, (Class) null, obj, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{(String) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[10].call(Introspector.class, str), String.class)}, new String[]{"", ""}), String.class));
        } else if (ScriptBytecodeAdapter.isCase(nestingType, callSiteArr$getCallSiteArray[11].callGetProperty(NestingType.class))) {
            ScriptBytecodeAdapter.invokeMethodN(PropertyUtil.class, obj, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{(String) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[12].call(PropertyUtil.class, str), String.class)}, new String[]{"add", ""}), String.class), new Object[]{obj2});
        }
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e4) {
            throw new NoClassDefFoundError(e4.getMessage());
        }
    }

    public static boolean hasAdderMethod(Object obj, String str) {
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        return DefaultTypeTransformation.booleanUnbox(callSiteArr$getCallSiteArray[1].call(callSiteArr$getCallSiteArray[2].callGetProperty(obj), obj, (String) ScriptBytecodeAdapter.castToType((__$stMC || BytecodeInterface8.disabledStandardMetaClass()) ? new GStringImpl(new Object[]{callSiteArr$getCallSiteArray[0].callStatic(PropertyUtil.class, str)}, new String[]{"add", ""}) : new GStringImpl(new Object[]{upperCaseFirstLetter(str)}, new String[]{"add", ""}), String.class)));
    }

    public static NestingType nestingType(Object obj, String str) {
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        return DefaultTypeTransformation.booleanUnbox(callSiteArr$getCallSiteArray[4].call(obj, callSiteArr$getCallSiteArray[3].call(Introspector.class, str))) ? (NestingType) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[5].callGetProperty(NestingType.class), NestingType.class) : DefaultTypeTransformation.booleanUnbox(callSiteArr$getCallSiteArray[6].callStatic(PropertyUtil.class, obj, str)) ? (NestingType) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[7].callGetProperty(NestingType.class), NestingType.class) : (NestingType) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[8].callGetProperty(NestingType.class), NestingType.class);
    }

    public static String transformFirstLetter(String str, Closure closure) {
        CallSite callSite;
        CallSite callSite2;
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        if (!BytecodeInterface8.isOrigInt() || !BytecodeInterface8.isOrigZ() || __$stMC || BytecodeInterface8.disabledStandardMetaClass()) {
            if (ScriptBytecodeAdapter.compareEqual(str, (Object) null) || ScriptBytecodeAdapter.compareEqual(callSiteArr$getCallSiteArray[13].call(str), 0)) {
                return str;
            }
        } else if (ScriptBytecodeAdapter.compareEqual(str, (Object) null) || ScriptBytecodeAdapter.compareEqual(callSiteArr$getCallSiteArray[14].call(str), 0)) {
            return str;
        }
        String str2 = (String) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[17].call(closure, (String) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[15].callConstructor(String.class, callSiteArr$getCallSiteArray[16].call(str, 0)), String.class)), String.class);
        if (!BytecodeInterface8.isOrigInt() || !BytecodeInterface8.isOrigZ() || __$stMC || BytecodeInterface8.disabledStandardMetaClass()) {
            if (ScriptBytecodeAdapter.compareEqual(callSiteArr$getCallSiteArray[18].call(str), 1)) {
                return str2;
            }
            callSite = callSiteArr$getCallSiteArray[19];
            callSite2 = callSiteArr$getCallSiteArray[20];
        } else {
            if (ScriptBytecodeAdapter.compareEqual(callSiteArr$getCallSiteArray[21].call(str), 1)) {
                return str2;
            }
            callSite = callSiteArr$getCallSiteArray[22];
            callSite2 = callSiteArr$getCallSiteArray[23];
        }
        return (String) ScriptBytecodeAdapter.castToType(callSite.call(str2, callSite2.call(str, 1)), String.class);
    }

    public static String upperCaseFirstLetter(String str) {
        return (String) ScriptBytecodeAdapter.castToType($getCallSiteArray()[24].callStatic(PropertyUtil.class, str, new _upperCaseFirstLetter_closure1(PropertyUtil.class, PropertyUtil.class)), String.class);
    }

    public /* synthetic */ MetaClass $getStaticMetaClass() {
        if (getClass() != PropertyUtil.class) {
            return ScriptBytecodeAdapter.initMetaClass(this);
        }
        ClassInfo classInfo = $staticClassInfo;
        if (classInfo == null) {
            classInfo = ClassInfo.getClassInfo(getClass());
            $staticClassInfo = classInfo;
        }
        return classInfo.getMetaClass();
    }

    public /* synthetic */ MetaClass getMetaClass() {
        MetaClass metaClass = this.metaClass;
        if (metaClass != null) {
            return metaClass;
        }
        MetaClass metaClass$getStaticMetaClass = $getStaticMetaClass();
        this.metaClass = metaClass$getStaticMetaClass;
        return metaClass$getStaticMetaClass;
    }

    public /* synthetic */ Object getProperty(String str) {
        return getMetaClass().getProperty(this, str);
    }

    public /* synthetic */ Object invokeMethod(String str, Object obj) {
        return getMetaClass().invokeMethod(this, str, obj);
    }

    public /* synthetic */ void setMetaClass(MetaClass metaClass) {
        this.metaClass = metaClass;
    }

    public /* synthetic */ void setProperty(String str, Object obj) {
        getMetaClass().setProperty(this, str, obj);
    }

    public /* synthetic */ Object super$1$clone() {
        return super.clone();
    }

    public /* synthetic */ boolean super$1$equals(Object obj) {
        return super.equals(obj);
    }

    public /* synthetic */ void super$1$finalize() throws Throwable {
        super.finalize();
    }

    public /* synthetic */ Class super$1$getClass() {
        return getClass();
    }

    public /* synthetic */ int super$1$hashCode() {
        return super.hashCode();
    }

    public /* synthetic */ void super$1$notify() {
        notify();
    }

    public /* synthetic */ void super$1$notifyAll() {
        notifyAll();
    }

    public /* synthetic */ String super$1$toString() {
        return super.toString();
    }

    public /* synthetic */ void super$1$wait() throws InterruptedException {
        wait();
    }

    public /* synthetic */ Object this$dist$get$1(String str) {
        $getCallSiteArray();
        return ScriptBytecodeAdapter.getGroovyObjectField(PropertyUtil.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class));
    }

    public /* synthetic */ Object this$dist$invoke$1(String str, Object obj) {
        $getCallSiteArray();
        return ScriptBytecodeAdapter.invokeMethodOnCurrentN(PropertyUtil.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class), ScriptBytecodeAdapter.despreadList(new Object[0], new Object[]{obj}, new int[]{0}));
    }

    public /* synthetic */ void this$dist$set$1(String str, Object obj) {
        $getCallSiteArray();
        ScriptBytecodeAdapter.setGroovyObjectField(obj, PropertyUtil.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class));
    }

    public /* synthetic */ void super$1$wait(long j4) throws InterruptedException {
        wait(j4);
    }

    public /* synthetic */ void super$1$wait(long j4, int i4) throws InterruptedException {
        wait(j4, i4);
    }
}
