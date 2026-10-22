package ch.qos.logback.classic.gaffer;

import ch.qos.logback.core.CoreConstants;
import com.baidu.platform.comapi.map.MapBundleKey;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import java.lang.ref.SoftReference;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.BytecodeInterface8;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSite;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;
import org.codehaus.groovy.runtime.typehandling.DefaultTypeTransformation;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class NestingType implements GroovyObject {
    private static final /* synthetic */ NestingType[] $VALUES;
    private static /* synthetic */ SoftReference $callSiteArray;
    private static /* synthetic */ ClassInfo $staticClassInfo;
    public static final NestingType AS_COLLECTION;
    public static final NestingType MAX_VALUE;
    public static final NestingType MIN_VALUE;
    public static final NestingType NA;
    public static final NestingType SINGLE;
    public static transient /* synthetic */ boolean __$stMC;
    public static /* synthetic */ long __timeStamp;
    public static /* synthetic */ long __timeStamp__239_neverHappen1396467705937;
    private transient /* synthetic */ MetaClass metaClass;

    public static final /* synthetic */ NestingType $INIT(Object... objArr) {
        $getCallSiteArray();
        Object[] objArrDespreadList = ScriptBytecodeAdapter.despreadList(new Object[0], new Object[]{objArr}, new int[]{0});
        int iSelectConstructorAndTransformArguments = ScriptBytecodeAdapter.selectConstructorAndTransformArguments(objArrDespreadList, 1, NestingType.class);
        if ((iSelectConstructorAndTransformArguments & 1) != 0) {
            objArrDespreadList = (Object[]) objArrDespreadList[0];
        }
        if ((iSelectConstructorAndTransformArguments >> 8) == 0) {
            return new NestingType((String) ScriptBytecodeAdapter.castToType(objArrDespreadList[0], String.class), DefaultTypeTransformation.intUnbox(objArrDespreadList[1]));
        }
        throw new IllegalArgumentException("illegal constructor number");
    }

    private static /* synthetic */ CallSiteArray $createCallSiteArray() {
        String[] strArr = new String[16];
        $createCallSiteArray_1(strArr);
        return new CallSiteArray(NestingType.class, strArr);
    }

    private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
        strArr[0] = "next";
        strArr[1] = "ordinal";
        strArr[2] = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE;
        strArr[3] = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE;
        strArr[4] = "getAt";
        strArr[5] = "previous";
        strArr[6] = "ordinal";
        strArr[7] = "minus";
        strArr[8] = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE;
        strArr[9] = "minus";
        strArr[10] = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE;
        strArr[11] = "getAt";
        strArr[12] = CoreConstants.VALUE_OF;
        strArr[13] = "$INIT";
        strArr[14] = "$INIT";
        strArr[15] = "$INIT";
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
        __timeStamp__239_neverHappen1396467705937 = 0L;
        __timeStamp = 1396467705937L;
        NestingType nestingType = (NestingType) ScriptBytecodeAdapter.castToType($getCallSiteArray()[13].callStatic(NestingType.class, "NA", 0), NestingType.class);
        NA = nestingType;
        NestingType nestingType2 = (NestingType) ScriptBytecodeAdapter.castToType($getCallSiteArray()[14].callStatic(NestingType.class, "SINGLE", 1), NestingType.class);
        SINGLE = nestingType2;
        NestingType nestingType3 = (NestingType) ScriptBytecodeAdapter.castToType($getCallSiteArray()[15].callStatic(NestingType.class, "AS_COLLECTION", 2), NestingType.class);
        AS_COLLECTION = nestingType3;
        MIN_VALUE = nestingType;
        MAX_VALUE = nestingType3;
        $VALUES = new NestingType[]{nestingType, nestingType2, nestingType3};
    }

    public NestingType(String str, int i4) {
        $getCallSiteArray();
        this.metaClass = $getStaticMetaClass();
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

    public static NestingType valueOf(String str) {
        return (NestingType) ScriptBytecodeAdapter.castToType($getCallSiteArray()[12].callStatic(NestingType.class, NestingType.class, str), NestingType.class);
    }

    public static final NestingType[] values() {
        $getCallSiteArray();
        return (NestingType[]) ScriptBytecodeAdapter.castToType($VALUES.clone(), NestingType[].class);
    }

    public /* synthetic */ MetaClass $getStaticMetaClass() {
        if (NestingType.class != NestingType.class) {
            return ScriptBytecodeAdapter.initMetaClass(this);
        }
        ClassInfo classInfo = $staticClassInfo;
        if (classInfo == null) {
            classInfo = ClassInfo.getClassInfo(NestingType.class);
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

    public /* synthetic */ NestingType next() {
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        Object obj = 0;
        Object objCall = callSiteArr$getCallSiteArray[0].call(callSiteArr$getCallSiteArray[1].callCurrent(this));
        if (!BytecodeInterface8.isOrigZ() || __$stMC || BytecodeInterface8.disabledStandardMetaClass() ? !ScriptBytecodeAdapter.compareGreaterThanEqual(objCall, callSiteArr$getCallSiteArray[2].call($VALUES)) : !ScriptBytecodeAdapter.compareGreaterThanEqual(objCall, callSiteArr$getCallSiteArray[3].call($VALUES))) {
            obj = objCall;
        }
        return (NestingType) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[4].call($VALUES, obj), NestingType.class);
    }

    public /* synthetic */ NestingType previous() {
        CallSite callSite;
        Object objCall;
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        Object objCall2 = callSiteArr$getCallSiteArray[5].call(callSiteArr$getCallSiteArray[6].callCurrent(this));
        if (!BytecodeInterface8.isOrigZ() || __$stMC || BytecodeInterface8.disabledStandardMetaClass()) {
            if (ScriptBytecodeAdapter.compareLessThan(objCall2, 0)) {
                callSite = callSiteArr$getCallSiteArray[7];
                objCall = callSiteArr$getCallSiteArray[8].call($VALUES);
                objCall2 = callSite.call(objCall, 1);
            }
        } else if (ScriptBytecodeAdapter.compareLessThan(objCall2, 0)) {
            callSite = callSiteArr$getCallSiteArray[9];
            objCall = callSiteArr$getCallSiteArray[10].call($VALUES);
            objCall2 = callSite.call(objCall, 1);
        }
        return (NestingType) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[11].call($VALUES, objCall2), NestingType.class);
    }

    public /* synthetic */ void setMetaClass(MetaClass metaClass) {
        this.metaClass = metaClass;
    }

    public /* synthetic */ void setProperty(String str, Object obj) {
        getMetaClass().setProperty(this, str, obj);
    }

    public /* synthetic */ Class super$1$getClass() {
        return getClass();
    }

    public /* synthetic */ void super$1$notify() {
        notify();
    }

    public /* synthetic */ void super$1$notifyAll() {
        notifyAll();
    }

    public /* synthetic */ void super$1$wait() throws InterruptedException {
        wait();
    }

    public /* synthetic */ Object super$2$clone() {
        return clone();
    }

    public /* synthetic */ int super$2$compareTo(Enum r12) {
        return compareTo((NestingType) r12);
    }

    public /* synthetic */ boolean super$2$equals(Object obj) {
        return equals(obj);
    }

    public /* synthetic */ void super$2$finalize() {
        finalize();
    }

    public /* synthetic */ Class super$2$getDeclaringClass() {
        return getDeclaringClass();
    }

    public /* synthetic */ int super$2$hashCode() {
        return hashCode();
    }

    public /* synthetic */ String super$2$name() {
        return name();
    }

    public /* synthetic */ int super$2$ordinal() {
        return ordinal();
    }

    public /* synthetic */ String super$2$toString() {
        return toString();
    }

    public /* synthetic */ void super$1$wait(long j4) throws InterruptedException {
        wait(j4);
    }

    public /* synthetic */ int super$2$compareTo(Object obj) {
        return compareTo((NestingType) obj);
    }

    public /* synthetic */ void super$1$wait(long j4, int i4) throws InterruptedException {
        wait(j4, i4);
    }
}
