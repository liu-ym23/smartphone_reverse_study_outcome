package ch.qos.logback.classic.gaffer;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusManager;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.stepos.alphame.awareness.AwarenessDataItem;
import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.List;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.BytecodeInterface8;
import org.codehaus.groovy.runtime.GStringImpl;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSite;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;
import org.codehaus.groovy.runtime.typehandling.DefaultTypeTransformation;

/* loaded from: classes.dex */
public class ComponentDelegate extends ContextAwareBase implements GroovyObject {
    private static /* synthetic */ SoftReference $callSiteArray;
    private static /* synthetic */ ClassInfo $staticClassInfo;
    public static transient /* synthetic */ boolean __$stMC;
    public static /* synthetic */ long __timeStamp;
    public static /* synthetic */ long __timeStamp__239_neverHappen1396467705944;
    private final Object component;
    private final List fieldsToCascade;
    private transient /* synthetic */ MetaClass metaClass;

    private static /* synthetic */ CallSiteArray $createCallSiteArray() {
        String[] strArr = new String[101];
        $createCallSiteArray_1(strArr);
        return new CallSiteArray(ComponentDelegate.class, strArr);
    }

    private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
        strArr[0] = "plus";
        strArr[1] = "toUpperCase";
        strArr[2] = "getAt";
        strArr[3] = "getLabel";
        strArr[4] = "substring";
        strArr[5] = "getLabel";
        strArr[6] = "plus";
        strArr[7] = "toUpperCase";
        strArr[8] = "getAt";
        strArr[9] = "substring";
        strArr[10] = "nestingType";
        strArr[11] = "NA";
        strArr[12] = "addError";
        strArr[13] = "getLabelFistLetterInUpperCase";
        strArr[14] = "getComponentName";
        strArr[15] = "canonicalName";
        strArr[16] = "getClass";
        strArr[17] = "NA";
        strArr[18] = "addError";
        strArr[19] = "canonicalName";
        strArr[20] = "getClass";
        strArr[21] = "analyzeArgs";
        strArr[22] = "getAt";
        strArr[23] = "getAt";
        strArr[24] = "getAt";
        strArr[25] = "newInstance";
        strArr[26] = "hasProperty";
        strArr[27] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[28] = "<$constructor$>";
        strArr[29] = "cascadeFields";
        strArr[30] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[31] = "injectParent";
        strArr[32] = "DELEGATE_FIRST";
        strArr[33] = "call";
        strArr[34] = "notMarkedWithNoAutoStart";
        strArr[35] = "start";
        strArr[36] = "attach";
        strArr[37] = "addError";
        strArr[38] = "getLabel";
        strArr[39] = "getComponentName";
        strArr[40] = "canonicalName";
        strArr[41] = "getClass";
        strArr[42] = "newInstance";
        strArr[43] = "hasProperty";
        strArr[44] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[45] = "<$constructor$>";
        strArr[46] = "cascadeFields";
        strArr[47] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[48] = "injectParent";
        strArr[49] = "DELEGATE_FIRST";
        strArr[50] = "call";
        strArr[51] = "notMarkedWithNoAutoStart";
        strArr[52] = "start";
        strArr[53] = "attach";
        strArr[54] = "addError";
        strArr[55] = "canonicalName";
        strArr[56] = "getClass";
        strArr[57] = "iterator";
        strArr[58] = "metaClass";
        strArr[59] = "hasProperty";
        strArr[60] = "nestingType";
        strArr[61] = "NA";
        strArr[62] = "addError";
        strArr[63] = "getLabelFistLetterInUpperCase";
        strArr[64] = "getComponentName";
        strArr[65] = "canonicalName";
        strArr[66] = "getClass";
        strArr[67] = "NA";
        strArr[68] = "addError";
        strArr[69] = "canonicalName";
        strArr[70] = "getClass";
        strArr[71] = "attach";
        strArr[72] = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE;
        strArr[73] = "addError";
        strArr[74] = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE;
        strArr[75] = "addError";
        strArr[76] = "getAt";
        strArr[77] = "getAt";
        strArr[78] = "minus";
        strArr[79] = "getAt";
        strArr[80] = "minus";
        strArr[81] = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE;
        strArr[82] = "parseClassArgument";
        strArr[83] = "getAt";
        strArr[84] = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE;
        strArr[85] = "parseClassArgument";
        strArr[86] = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE;
        strArr[87] = "parseNameArgument";
        strArr[88] = "getAt";
        strArr[89] = "parseClassArgument";
        strArr[90] = "getAt";
        strArr[91] = MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE;
        strArr[92] = "parseNameArgument";
        strArr[93] = "parseClassArgument";
        strArr[94] = "forName";
        strArr[95] = "addError";
        strArr[96] = "canonicalName";
        strArr[97] = "getClass";
        strArr[98] = "addError";
        strArr[99] = "hasProperty";
        strArr[100] = "name";
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
        __timeStamp__239_neverHappen1396467705944 = 0L;
        __timeStamp = 1396467705944L;
    }

    public ComponentDelegate(Object obj) {
        $getCallSiteArray();
        this.fieldsToCascade = ScriptBytecodeAdapter.createList(new Object[0]);
        this.metaClass = $getStaticMetaClass();
        this.component = obj;
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
        if (getClass() != ComponentDelegate.class) {
            return ScriptBytecodeAdapter.initMetaClass(this);
        }
        ClassInfo classInfo = $staticClassInfo;
        if (classInfo == null) {
            classInfo = ClassInfo.getClassInfo(getClass());
            $staticClassInfo = classInfo;
        }
        return classInfo.getMetaClass();
    }

    public Object analyzeArgs(Object... objArr) {
        Closure closure;
        CallSite callSite;
        Object objCall;
        CallSite callSite2;
        Object objCall2;
        Class cls;
        Object objCallCurrent;
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        String str = null;
        if (!BytecodeInterface8.isOrigInt() || !BytecodeInterface8.isOrigZ() || __$stMC || BytecodeInterface8.disabledStandardMetaClass()) {
            if (ScriptBytecodeAdapter.compareGreaterThan(callSiteArr$getCallSiteArray[72].call(objArr), 3)) {
                callSiteArr$getCallSiteArray[73].callCurrent(this, new GStringImpl(new Object[]{objArr}, new String[]{"At most 3 arguments allowed but you passed ", ""}));
                return ScriptBytecodeAdapter.createList(new Object[]{null, null, null});
            }
        } else if (ScriptBytecodeAdapter.compareGreaterThan(callSiteArr$getCallSiteArray[74].call(objArr), 3)) {
            callSiteArr$getCallSiteArray[75].callCurrent(this, new GStringImpl(new Object[]{objArr}, new String[]{"At most 3 arguments allowed but you passed ", ""}));
            return ScriptBytecodeAdapter.createList(new Object[]{null, null, null});
        }
        if (__$stMC || BytecodeInterface8.disabledStandardMetaClass()) {
            if (callSiteArr$getCallSiteArray[76].call(objArr, -1) instanceof Closure) {
                closure = (Closure) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[77].call(objArr, -1), Closure.class);
                callSite = callSiteArr$getCallSiteArray[78];
                objCall = callSiteArr$getCallSiteArray[79].call(objArr, -1);
                objArr = (Object[]) ScriptBytecodeAdapter.castToType(callSite.call(objArr, objCall), Object[].class);
            }
            closure = null;
        } else {
            if (BytecodeInterface8.objectArrayGet(objArr, -1) instanceof Closure) {
                closure = (Closure) ScriptBytecodeAdapter.castToType(BytecodeInterface8.objectArrayGet(objArr, -1), Closure.class);
                callSite = callSiteArr$getCallSiteArray[80];
                objCall = BytecodeInterface8.objectArrayGet(objArr, -1);
                objArr = (Object[]) ScriptBytecodeAdapter.castToType(callSite.call(objArr, objCall), Object[].class);
            }
            closure = null;
        }
        if (!BytecodeInterface8.isOrigInt() || !BytecodeInterface8.isOrigZ() || __$stMC || BytecodeInterface8.disabledStandardMetaClass()) {
            if (ScriptBytecodeAdapter.compareEqual(callSiteArr$getCallSiteArray[81].call(objArr), 1)) {
                callSite2 = callSiteArr$getCallSiteArray[82];
                objCall2 = callSiteArr$getCallSiteArray[83].call(objArr, 0);
                cls = (Class) ScriptBytecodeAdapter.castToType(callSite2.callCurrent(this, objCall2), Class.class);
            }
            cls = null;
        } else {
            if (ScriptBytecodeAdapter.compareEqual(callSiteArr$getCallSiteArray[84].call(objArr), 1)) {
                callSite2 = callSiteArr$getCallSiteArray[85];
                objCall2 = BytecodeInterface8.objectArrayGet(objArr, 0);
                cls = (Class) ScriptBytecodeAdapter.castToType(callSite2.callCurrent(this, objCall2), Class.class);
            }
            cls = null;
        }
        if (!BytecodeInterface8.isOrigInt() || !BytecodeInterface8.isOrigZ() || __$stMC || BytecodeInterface8.disabledStandardMetaClass()) {
            if (ScriptBytecodeAdapter.compareEqual(callSiteArr$getCallSiteArray[86].call(objArr), 2)) {
                str = (String) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[87].callCurrent(this, callSiteArr$getCallSiteArray[88].call(objArr, 0)), String.class);
                objCallCurrent = callSiteArr$getCallSiteArray[89].callCurrent(this, callSiteArr$getCallSiteArray[90].call(objArr, 1));
                cls = (Class) ScriptBytecodeAdapter.castToType(objCallCurrent, Class.class);
            }
        } else if (ScriptBytecodeAdapter.compareEqual(callSiteArr$getCallSiteArray[91].call(objArr), 2)) {
            str = (String) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[92].callCurrent(this, BytecodeInterface8.objectArrayGet(objArr, 0)), String.class);
            objCallCurrent = callSiteArr$getCallSiteArray[93].callCurrent(this, BytecodeInterface8.objectArrayGet(objArr, 1));
            cls = (Class) ScriptBytecodeAdapter.castToType(objCallCurrent, Class.class);
        }
        return ScriptBytecodeAdapter.createList(new Object[]{str, cls, closure});
    }

    public void cascadeFields(ComponentDelegate componentDelegate) {
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        Iterator it = (Iterator) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[57].call(this.fieldsToCascade), Iterator.class);
        while (it.hasNext()) {
            String str = (String) ScriptBytecodeAdapter.castToType(it.next(), String.class);
            ScriptBytecodeAdapter.setProperty(ScriptBytecodeAdapter.getGroovyObjectProperty(ComponentDelegate.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class)), (Class) null, callSiteArr$getCallSiteArray[58].callGroovyObjectGetProperty(componentDelegate), (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class));
        }
    }

    public final Object getComponent() {
        return this.component;
    }

    public String getComponentName() {
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        return DefaultTypeTransformation.booleanUnbox(callSiteArr$getCallSiteArray[99].call(this.component, "name")) ? (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{callSiteArr$getCallSiteArray[100].callGetProperty(this.component)}, new String[]{"[", "]"}), String.class) : "";
    }

    public final List getFieldsToCascade() {
        return this.fieldsToCascade;
    }

    public String getLabel() {
        $getCallSiteArray();
        return "component";
    }

    public String getLabelFistLetterInUpperCase() {
        CallSite callSite;
        Object objCall;
        Object objCall2;
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        if (__$stMC || BytecodeInterface8.disabledStandardMetaClass()) {
            callSite = callSiteArr$getCallSiteArray[0];
            objCall = callSiteArr$getCallSiteArray[1].call(callSiteArr$getCallSiteArray[2].call(callSiteArr$getCallSiteArray[3].callCurrent(this), 0));
            objCall2 = callSiteArr$getCallSiteArray[4].call(callSiteArr$getCallSiteArray[5].callCurrent(this), 1);
        } else {
            callSite = callSiteArr$getCallSiteArray[6];
            objCall = callSiteArr$getCallSiteArray[7].call(callSiteArr$getCallSiteArray[8].call(getLabel(), 0));
            objCall2 = callSiteArr$getCallSiteArray[9].call(getLabel(), 1);
        }
        return (String) ScriptBytecodeAdapter.castToType(callSite.call(objCall, objCall2), String.class);
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

    public void injectParent(Object obj) {
        if (DefaultTypeTransformation.booleanUnbox($getCallSiteArray()[59].call(obj, "parent"))) {
            ScriptBytecodeAdapter.setProperty(this.component, (Class) null, obj, "parent");
        }
    }

    public /* synthetic */ Object invokeMethod(String str, Object obj) {
        return getMetaClass().invokeMethod(this, str, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void methodMissing(java.lang.String r21, java.lang.Object r22) {
        /*
            Method dump skipped, instructions count: 750
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.classic.gaffer.ComponentDelegate.methodMissing(java.lang.String, java.lang.Object):void");
    }

    public Class parseClassArgument(Object obj) {
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        if (obj instanceof Class) {
            return (Class) ScriptBytecodeAdapter.castToType(obj, Class.class);
        }
        if (obj instanceof String) {
            return (Class) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[94].call(Class.class, obj), Class.class);
        }
        callSiteArr$getCallSiteArray[95].callCurrent(this, new GStringImpl(new Object[]{callSiteArr$getCallSiteArray[96].callGetProperty(callSiteArr$getCallSiteArray[97].call(obj))}, new String[]{"Unexpected argument type ", ""}));
        return (Class) ScriptBytecodeAdapter.castToType((Object) null, Class.class);
    }

    public String parseNameArgument(Object obj) {
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        if (obj instanceof String) {
            return (String) ScriptBytecodeAdapter.castToType(obj, String.class);
        }
        callSiteArr$getCallSiteArray[98].callCurrent(this, "With 2 or 3 arguments, the first argument must be the component name, i.e of type string");
        return (String) ScriptBytecodeAdapter.castToType((Object) null, String.class);
    }

    public void propertyMissing(String str, Object obj) {
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        NestingType nestingType = (NestingType) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[60].call(PropertyUtil.class, this.component, str), NestingType.class);
        if (!BytecodeInterface8.isOrigZ() || __$stMC || BytecodeInterface8.disabledStandardMetaClass()) {
            if (ScriptBytecodeAdapter.compareEqual(nestingType, callSiteArr$getCallSiteArray[61].callGetProperty(NestingType.class))) {
                callSiteArr$getCallSiteArray[62].callCurrent(this, new GStringImpl(new Object[]{callSiteArr$getCallSiteArray[63].callCurrent(this), callSiteArr$getCallSiteArray[64].callCurrent(this), callSiteArr$getCallSiteArray[65].callGetProperty(callSiteArr$getCallSiteArray[66].call(this.component)), str}, new String[]{"", AwarenessDataItem.PERMISSION_SPLITTER, " of type [", "] has no appplicable [", "] property "}));
                return;
            }
        } else if (ScriptBytecodeAdapter.compareEqual(nestingType, callSiteArr$getCallSiteArray[67].callGetProperty(NestingType.class))) {
            callSiteArr$getCallSiteArray[68].callCurrent(this, new GStringImpl(new Object[]{getLabelFistLetterInUpperCase(), getComponentName(), callSiteArr$getCallSiteArray[69].callGetProperty(callSiteArr$getCallSiteArray[70].call(this.component)), str}, new String[]{"", AwarenessDataItem.PERMISSION_SPLITTER, " of type [", "] has no appplicable [", "] property "}));
            return;
        }
        callSiteArr$getCallSiteArray[71].call(PropertyUtil.class, nestingType, this.component, obj, str);
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

    public /* synthetic */ void super$2$addError(String str) {
        super.addError(str);
    }

    public /* synthetic */ void super$2$addInfo(String str) {
        super.addInfo(str);
    }

    public /* synthetic */ void super$2$addStatus(Status status) {
        super.addStatus(status);
    }

    public /* synthetic */ void super$2$addWarn(String str) {
        super.addWarn(str);
    }

    public /* synthetic */ Context super$2$getContext() {
        return super.getContext();
    }

    public /* synthetic */ Object super$2$getDeclaredOrigin() {
        return super.getDeclaredOrigin();
    }

    public /* synthetic */ StatusManager super$2$getStatusManager() {
        return super.getStatusManager();
    }

    public /* synthetic */ void super$2$setContext(Context context) {
        super.setContext(context);
    }

    public /* synthetic */ Object this$dist$get$2(String str) {
        $getCallSiteArray();
        return ScriptBytecodeAdapter.getGroovyObjectField(ComponentDelegate.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class));
    }

    public /* synthetic */ Object this$dist$invoke$2(String str, Object obj) {
        $getCallSiteArray();
        return ScriptBytecodeAdapter.invokeMethodOnCurrentN(ComponentDelegate.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class), ScriptBytecodeAdapter.despreadList(new Object[0], new Object[]{obj}, new int[]{0}));
    }

    public /* synthetic */ void this$dist$set$2(String str, Object obj) {
        $getCallSiteArray();
        ScriptBytecodeAdapter.setGroovyObjectField(obj, ComponentDelegate.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class));
    }

    public /* synthetic */ void super$1$wait(long j4) throws InterruptedException {
        wait(j4);
    }

    public /* synthetic */ void super$2$addError(String str, Throwable th) {
        super.addError(str, th);
    }

    public /* synthetic */ void super$2$addInfo(String str, Throwable th) {
        super.addInfo(str, th);
    }

    public /* synthetic */ void super$2$addWarn(String str, Throwable th) {
        super.addWarn(str, th);
    }

    public /* synthetic */ void super$1$wait(long j4, int i4) throws InterruptedException {
        wait(j4, i4);
    }
}
