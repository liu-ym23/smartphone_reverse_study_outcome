package ch.qos.logback.classic.gaffer;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.jmx.JMXConfigurator;
import ch.qos.logback.classic.jmx.MBeanUtil;
import ch.qos.logback.classic.net.ReceiverBase;
import ch.qos.logback.classic.turbo.ReconfigureOnChangeFilter;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.LifeCycle;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusListener;
import ch.qos.logback.core.status.StatusManager;
import ch.qos.logback.core.util.CachingDateFormatter;
import ch.qos.logback.core.util.Duration;
import com.alibaba.fastjson.asm.Opcodes;
import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import groovy.lang.Reference;
import java.lang.management.ManagementFactory;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import n3.InterfaceC0781b;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.BytecodeInterface8;
import org.codehaus.groovy.runtime.GStringImpl;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSite;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;
import org.codehaus.groovy.runtime.typehandling.DefaultTypeTransformation;

/* loaded from: classes.dex */
public class ConfigurationDelegate extends ContextAwareBase implements GroovyObject {
    private static /* synthetic */ SoftReference $callSiteArray;
    private static /* synthetic */ ClassInfo $staticClassInfo;
    public static transient /* synthetic */ boolean __$stMC;
    public static /* synthetic */ long __timeStamp;
    public static /* synthetic */ long __timeStamp__239_neverHappen1396467705878;
    private List<Appender> appenderList;
    private transient /* synthetic */ MetaClass metaClass;

    class _copyContributions_closure2 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference $callSiteArray;
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference appender;
        private /* synthetic */ Reference appenderDelegate;

        private static /* synthetic */ CallSiteArray $createCallSiteArray() {
            String[] strArr = new String[2];
            $createCallSiteArray_1(strArr);
            return new CallSiteArray(_copyContributions_closure2.class, strArr);
        }

        private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
            strArr[0] = "metaClass";
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
        public _copyContributions_closure2(Object obj, Object obj2, Reference reference, Reference reference2) {
            super(obj, obj2);
            $getCallSiteArray();
            this.appenderDelegate = reference;
            this.appender = reference2;
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
            if (getClass() != _copyContributions_closure2.class) {
                return ScriptBytecodeAdapter.initMetaClass(this);
            }
            ClassInfo classInfo = $staticClassInfo;
            if (classInfo == null) {
                classInfo = ClassInfo.getClassInfo(getClass());
                $staticClassInfo = classInfo;
            }
            return classInfo.getMetaClass();
        }

        public Object call(Object obj, Object obj2) {
            return $getCallSiteArray()[1].callCurrent(this, obj, obj2);
        }

        public Object doCall(Object obj, Object obj2) {
            CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
            Closure methodPointer = ScriptBytecodeAdapter.getMethodPointer(this.appender.get(), (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{obj}, new String[]{"", ""}), String.class));
            ScriptBytecodeAdapter.setProperty(methodPointer, (Class) null, callSiteArr$getCallSiteArray[0].callGetProperty(this.appenderDelegate.get()), (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{obj2}, new String[]{"", ""}), String.class));
            return methodPointer;
        }

        public Appender getAppender() {
            $getCallSiteArray();
            return (Appender) ScriptBytecodeAdapter.castToType(this.appender.get(), Appender.class);
        }

        public AppenderDelegate getAppenderDelegate() {
            $getCallSiteArray();
            return (AppenderDelegate) ScriptBytecodeAdapter.castToType(this.appenderDelegate.get(), AppenderDelegate.class);
        }
    }

    class _logger_closure1 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference $callSiteArray;
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference aName;

        private static /* synthetic */ CallSiteArray $createCallSiteArray() {
            String[] strArr = new String[2];
            $createCallSiteArray_1(strArr);
            return new CallSiteArray(_logger_closure1.class, strArr);
        }

        private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
            strArr[0] = "name";
            strArr[1] = "name";
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
        public _logger_closure1(Object obj, Object obj2, Reference reference) {
            super(obj, obj2);
            $getCallSiteArray();
            this.aName = reference;
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
            if (getClass() != _logger_closure1.class) {
                return ScriptBytecodeAdapter.initMetaClass(this);
            }
            ClassInfo classInfo = $staticClassInfo;
            if (classInfo == null) {
                classInfo = ClassInfo.getClassInfo(getClass());
                $staticClassInfo = classInfo;
            }
            return classInfo.getMetaClass();
        }

        public Object doCall(Object obj) {
            CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
            return Boolean.valueOf(ScriptBytecodeAdapter.compareEqual(((!BytecodeInterface8.isOrigZ() || __$stMC || BytecodeInterface8.disabledStandardMetaClass()) ? callSiteArr$getCallSiteArray[0] : callSiteArr$getCallSiteArray[1]).callGetProperty(obj), this.aName.get()));
        }

        public Object getaName() {
            $getCallSiteArray();
            return this.aName.get();
        }
    }

    private static /* synthetic */ CallSiteArray $createCallSiteArray() {
        String[] strArr = new String[Opcodes.IFLE];
        $createCallSiteArray_1(strArr);
        return new CallSiteArray(ConfigurationDelegate.class, strArr);
    }

    private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
        strArr[0] = "<$constructor$>";
        strArr[1] = "setContext";
        strArr[2] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[3] = CoreConstants.VALUE_OF;
        strArr[4] = "setRefreshPeriod";
        strArr[5] = "getMilliseconds";
        strArr[6] = "addInfo";
        strArr[7] = "plus";
        strArr[8] = "addError";
        strArr[9] = "plus";
        strArr[10] = "plus";
        strArr[11] = "scanAttrib";
        strArr[12] = "start";
        strArr[13] = "addInfo";
        strArr[14] = "addTurboFilter";
        strArr[15] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[16] = "newInstance";
        strArr[17] = "add";
        strArr[18] = "statusManager";
        strArr[19] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[20] = "setContext";
        strArr[21] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[22] = "start";
        strArr[23] = "addInfo";
        strArr[24] = "canonicalName";
        strArr[25] = "getName";
        strArr[26] = "getObject";
        strArr[27] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[28] = CoreConstants.PATTERN_RULE_REGISTRY;
        strArr[29] = "<$constructor$>";
        strArr[30] = "putObject";
        strArr[31] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[32] = CoreConstants.PATTERN_RULE_REGISTRY;
        strArr[33] = "<$constructor$>";
        strArr[34] = "putObject";
        strArr[35] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[36] = CoreConstants.PATTERN_RULE_REGISTRY;
        strArr[37] = "addInfo";
        strArr[38] = "plus";
        strArr[39] = "plus";
        strArr[40] = "plus";
        strArr[41] = "plus";
        strArr[42] = "put";
        strArr[43] = "addError";
        strArr[44] = "logger";
        strArr[45] = "ROOT_LOGGER_NAME";
        strArr[46] = "addError";
        strArr[47] = "logger";
        strArr[48] = "ROOT_LOGGER_NAME";
        strArr[49] = "getLogger";
        strArr[50] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[51] = "addInfo";
        strArr[52] = "plus";
        strArr[53] = "iterator";
        strArr[54] = "find";
        strArr[55] = "addInfo";
        strArr[56] = "plus";
        strArr[57] = "addAppender";
        strArr[58] = "addError";
        strArr[59] = "addInfo";
        strArr[60] = "addInfo";
        strArr[61] = "plus";
        strArr[62] = "plus";
        strArr[63] = "name";
        strArr[64] = "newInstance";
        strArr[65] = "addInfo";
        strArr[66] = "plus";
        strArr[67] = "plus";
        strArr[68] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[69] = "add";
        strArr[70] = "name";
        strArr[71] = "<$constructor$>";
        strArr[72] = "<$constructor$>";
        strArr[73] = "copyContributions";
        strArr[74] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[75] = "DELEGATE_FIRST";
        strArr[76] = "call";
        strArr[77] = "name";
        strArr[78] = "<$constructor$>";
        strArr[79] = "<$constructor$>";
        strArr[80] = "copyContributions";
        strArr[81] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[82] = "DELEGATE_FIRST";
        strArr[83] = "call";
        strArr[84] = "start";
        strArr[85] = "addError";
        strArr[86] = "plus";
        strArr[87] = "plus";
        strArr[88] = "addInfo";
        strArr[89] = "plus";
        strArr[90] = "plus";
        strArr[91] = "name";
        strArr[92] = "clazz";
        strArr[93] = "newInstance";
        strArr[94] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[95] = "<$constructor$>";
        strArr[96] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[97] = "DELEGATE_FIRST";
        strArr[98] = "call";
        strArr[99] = "<$constructor$>";
        strArr[100] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[101] = "DELEGATE_FIRST";
        strArr[102] = "call";
        strArr[103] = "start";
        strArr[104] = "addError";
        strArr[105] = "plus";
        strArr[106] = "plus";
        strArr[107] = "getName";
        strArr[108] = "each";
        strArr[109] = "getMappings";
        strArr[110] = "addInfo";
        strArr[111] = "plus";
        strArr[112] = "plus";
        strArr[113] = "name";
        strArr[114] = "newInstance";
        strArr[115] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[116] = "<$constructor$>";
        strArr[117] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[118] = "DELEGATE_FIRST";
        strArr[119] = "call";
        strArr[120] = "<$constructor$>";
        strArr[121] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[122] = "DELEGATE_FIRST";
        strArr[123] = "call";
        strArr[124] = "start";
        strArr[125] = "addInfo";
        strArr[126] = "addTurboFilter";
        strArr[127] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[128] = "addInfo";
        strArr[129] = "currentTimeMillis";
        strArr[130] = "addInfo";
        strArr[131] = "plus";
        strArr[132] = "plus";
        strArr[133] = "addInfo";
        strArr[134] = "currentTimeMillis";
        strArr[135] = "addInfo";
        strArr[136] = "plus";
        strArr[137] = "plus";
        strArr[138] = "<$constructor$>";
        strArr[139] = "format";
        strArr[140] = "name";
        strArr[141] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[142] = "<$constructor$>";
        strArr[143] = "<$constructor$>";
        strArr[144] = "getObjectNameFor";
        strArr[145] = "string2ObjectName";
        strArr[146] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[147] = "addError";
        strArr[148] = "getObjectNameFor";
        strArr[149] = "string2ObjectName";
        strArr[150] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[151] = "addError";
        strArr[152] = "platformMBeanServer";
        strArr[153] = "isRegistered";
        strArr[154] = "<$constructor$>";
        strArr[155] = CoreConstants.CONTEXT_SCOPE_VALUE;
        strArr[156] = "registerMBean";
        strArr[157] = "addError";
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
        __timeStamp__239_neverHappen1396467705878 = 0L;
        __timeStamp = 1396467705878L;
    }

    public ConfigurationDelegate() {
        $getCallSiteArray();
        this.appenderList = ScriptBytecodeAdapter.createList(new Object[0]);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: copyContributions, reason: merged with bridge method [inline-methods] */
    public void this$3$copyContributions(AppenderDelegate appenderDelegate, Appender appender) {
        Reference reference = new Reference(appenderDelegate);
        Reference reference2 = new Reference(appender);
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        if (((Appender) reference2.get()) instanceof ConfigurationContributor) {
            callSiteArr$getCallSiteArray[108].call(callSiteArr$getCallSiteArray[109].call((ConfigurationContributor) ScriptBytecodeAdapter.castToType((Appender) reference2.get(), ConfigurationContributor.class)), new _copyContributions_closure2(this, this, reference, reference2));
        }
    }

    public /* synthetic */ MetaClass $getStaticMetaClass() {
        if (getClass() != ConfigurationDelegate.class) {
            return ScriptBytecodeAdapter.initMetaClass(this);
        }
        ClassInfo classInfo = $staticClassInfo;
        if (classInfo == null) {
            classInfo = ClassInfo.getClassInfo(getClass());
            $staticClassInfo = classInfo;
        }
        return classInfo.getMetaClass();
    }

    public void appender(String str, Class cls) {
        $getCallSiteArray();
        appender(str, cls, null);
    }

    public void conversionRule(String str, Class cls) {
        CallSite callSite;
        Object objCallGroovyObjectGetProperty;
        CallSite callSite2;
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        String str2 = (String) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[25].call(cls), String.class);
        Map map = (Map) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[26].call(callSiteArr$getCallSiteArray[27].callGroovyObjectGetProperty(this), callSiteArr$getCallSiteArray[28].callGetProperty(CoreConstants.class)), Map.class);
        if (!BytecodeInterface8.isOrigZ() || __$stMC || BytecodeInterface8.disabledStandardMetaClass()) {
            if (ScriptBytecodeAdapter.compareEqual(map, (Object) null)) {
                map = (Map) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[29].callConstructor(HashMap.class), Map.class);
                callSite = callSiteArr$getCallSiteArray[30];
                objCallGroovyObjectGetProperty = callSiteArr$getCallSiteArray[31].callGroovyObjectGetProperty(this);
                callSite2 = callSiteArr$getCallSiteArray[32];
                callSite.call(objCallGroovyObjectGetProperty, callSite2.callGetProperty(CoreConstants.class), map);
            }
        } else if (ScriptBytecodeAdapter.compareEqual(map, (Object) null)) {
            map = (Map) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[33].callConstructor(HashMap.class), Map.class);
            callSite = callSiteArr$getCallSiteArray[34];
            objCallGroovyObjectGetProperty = callSiteArr$getCallSiteArray[35].callGroovyObjectGetProperty(this);
            callSite2 = callSiteArr$getCallSiteArray[36];
            callSite.call(objCallGroovyObjectGetProperty, callSite2.callGetProperty(CoreConstants.class), map);
        }
        callSiteArr$getCallSiteArray[37].callCurrent(this, callSiteArr$getCallSiteArray[38].call(callSiteArr$getCallSiteArray[39].call(callSiteArr$getCallSiteArray[40].call(callSiteArr$getCallSiteArray[41].call("registering conversion word ", str), " with class ["), str2), "]"));
        callSiteArr$getCallSiteArray[42].call(map, str, str2);
    }

    public List<Appender> getAppenderList() {
        return this.appenderList;
    }

    @Override // ch.qos.logback.core.spi.ContextAwareBase
    public Object getDeclaredOrigin() {
        $getCallSiteArray();
        return this;
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

    public void jmxConfigurator() {
        $getCallSiteArray();
        if (!__$stMC) {
            BytecodeInterface8.disabledStandardMetaClass();
        }
        jmxConfigurator(null);
    }

    public void logger(String str, Level level, List<String> list) {
        $getCallSiteArray();
        logger(str, level, list, null);
    }

    public void receiver(String str, Class cls) {
        $getCallSiteArray();
        receiver(str, cls, null);
    }

    public void root(Level level) {
        $getCallSiteArray();
        root(level, ScriptBytecodeAdapter.createList(new Object[0]));
    }

    public void scan() {
        $getCallSiteArray();
        if (!__$stMC) {
            BytecodeInterface8.disabledStandardMetaClass();
        }
        scan(null);
    }

    public void setAppenderList(List<Appender> list) {
        this.appenderList = list;
    }

    public /* synthetic */ void setMetaClass(MetaClass metaClass) {
        this.metaClass = metaClass;
    }

    public /* synthetic */ void setProperty(String str, Object obj) {
        getMetaClass().setProperty(this, str, obj);
    }

    public void statusListener(Class cls) {
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        StatusListener statusListener = (StatusListener) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[16].call(cls), StatusListener.class);
        callSiteArr$getCallSiteArray[17].call(callSiteArr$getCallSiteArray[18].callGetProperty(callSiteArr$getCallSiteArray[19].callGroovyObjectGetProperty(this)), statusListener);
        if (statusListener instanceof ContextAware) {
            callSiteArr$getCallSiteArray[20].call((ContextAware) ScriptBytecodeAdapter.castToType(statusListener, ContextAware.class), callSiteArr$getCallSiteArray[21].callGroovyObjectGetProperty(this));
        }
        if (statusListener instanceof LifeCycle) {
            callSiteArr$getCallSiteArray[22].call((LifeCycle) ScriptBytecodeAdapter.castToType(statusListener, LifeCycle.class));
        }
        callSiteArr$getCallSiteArray[23].callCurrent(this, new GStringImpl(new Object[]{callSiteArr$getCallSiteArray[24].callGetProperty(cls)}, new String[]{"Added status listener of type [", "]"}));
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
        return ScriptBytecodeAdapter.getGroovyObjectField(ConfigurationDelegate.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class));
    }

    public /* synthetic */ Object this$dist$invoke$2(String str, Object obj) {
        $getCallSiteArray();
        return ScriptBytecodeAdapter.invokeMethodOnCurrentN(ConfigurationDelegate.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class), ScriptBytecodeAdapter.despreadList(new Object[0], new Object[]{obj}, new int[]{0}));
    }

    public /* synthetic */ void this$dist$set$2(String str, Object obj) {
        $getCallSiteArray();
        ScriptBytecodeAdapter.setGroovyObjectField(obj, ConfigurationDelegate.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class));
    }

    public String timestamp(String str) {
        $getCallSiteArray();
        if (!__$stMC) {
            BytecodeInterface8.disabledStandardMetaClass();
        }
        return timestamp(str, -1);
    }

    public void turboFilter(Class cls) {
        $getCallSiteArray();
        turboFilter(cls, null);
    }

    public void appender(String str, Class cls, Closure closure) {
        CallSite callSite;
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        callSiteArr$getCallSiteArray[60].callCurrent(this, callSiteArr$getCallSiteArray[61].call(callSiteArr$getCallSiteArray[62].call("About to instantiate appender of type [", callSiteArr$getCallSiteArray[63].callGetProperty(cls)), "]"));
        Appender appender = (Appender) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[64].call(cls), Appender.class);
        callSiteArr$getCallSiteArray[65].callCurrent(this, callSiteArr$getCallSiteArray[66].call(callSiteArr$getCallSiteArray[67].call("Naming appender as [", str), "]"));
        ScriptBytecodeAdapter.setProperty(str, (Class) null, appender, "name");
        ScriptBytecodeAdapter.setProperty(callSiteArr$getCallSiteArray[68].callGroovyObjectGetProperty(this), (Class) null, appender, CoreConstants.CONTEXT_SCOPE_VALUE);
        callSiteArr$getCallSiteArray[69].call(this.appenderList, appender);
        if (!BytecodeInterface8.isOrigZ() || __$stMC || BytecodeInterface8.disabledStandardMetaClass()) {
            if (ScriptBytecodeAdapter.compareNotEqual(closure, (Object) null)) {
                AppenderDelegate appenderDelegate = (AppenderDelegate) ScriptBytecodeAdapter.castToType(ScriptBytecodeAdapter.compareEqual(callSiteArr$getCallSiteArray[70].callGetProperty(cls), "ch.qos.logback.classic.AsyncAppender") ? callSiteArr$getCallSiteArray[71].callConstructor(AsyncAppenderDelegate.class, appender, this.appenderList) : callSiteArr$getCallSiteArray[72].callConstructor(AppenderDelegate.class, appender), AppenderDelegate.class);
                callSiteArr$getCallSiteArray[73].callCurrent(this, appenderDelegate, appender);
                ScriptBytecodeAdapter.setProperty(callSiteArr$getCallSiteArray[74].callGroovyObjectGetProperty(this), (Class) null, appenderDelegate, CoreConstants.CONTEXT_SCOPE_VALUE);
                ScriptBytecodeAdapter.setGroovyObjectProperty(appenderDelegate, ConfigurationDelegate.class, closure, "delegate");
                ScriptBytecodeAdapter.setGroovyObjectProperty(callSiteArr$getCallSiteArray[75].callGetProperty(Closure.class), ConfigurationDelegate.class, closure, "resolveStrategy");
                callSite = callSiteArr$getCallSiteArray[76];
                callSite.call(closure);
            }
        } else if (ScriptBytecodeAdapter.compareNotEqual(closure, (Object) null)) {
            AppenderDelegate appenderDelegate2 = (AppenderDelegate) ScriptBytecodeAdapter.castToType(ScriptBytecodeAdapter.compareEqual(callSiteArr$getCallSiteArray[77].callGetProperty(cls), "ch.qos.logback.classic.AsyncAppender") ? callSiteArr$getCallSiteArray[78].callConstructor(AsyncAppenderDelegate.class, appender, this.appenderList) : callSiteArr$getCallSiteArray[79].callConstructor(AppenderDelegate.class, appender), AppenderDelegate.class);
            callSiteArr$getCallSiteArray[80].callCurrent(this, appenderDelegate2, appender);
            ScriptBytecodeAdapter.setProperty(callSiteArr$getCallSiteArray[81].callGroovyObjectGetProperty(this), (Class) null, appenderDelegate2, CoreConstants.CONTEXT_SCOPE_VALUE);
            ScriptBytecodeAdapter.setGroovyObjectProperty(appenderDelegate2, ConfigurationDelegate.class, closure, "delegate");
            ScriptBytecodeAdapter.setGroovyObjectProperty(callSiteArr$getCallSiteArray[82].callGetProperty(Closure.class), ConfigurationDelegate.class, closure, "resolveStrategy");
            callSite = callSiteArr$getCallSiteArray[83];
            callSite.call(closure);
        }
        try {
            callSiteArr$getCallSiteArray[84].call(appender);
        } catch (RuntimeException e4) {
            callSiteArr$getCallSiteArray[85].callCurrent(this, callSiteArr$getCallSiteArray[86].call(callSiteArr$getCallSiteArray[87].call("Failed to start apppender named [", str), "]"), e4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v17, types: [java.lang.Object] */
    public void jmxConfigurator(String str) {
        ?? Call;
        CallSite callSite;
        GStringImpl gStringImpl;
        String str2;
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        Object objCallGetProperty = callSiteArr$getCallSiteArray[140].callGetProperty(callSiteArr$getCallSiteArray[141].callGroovyObjectGetProperty(this));
        try {
        } catch (MalformedObjectNameException unused) {
            objCallGetProperty = str;
        }
        if (!BytecodeInterface8.isOrigZ() || __$stMC || BytecodeInterface8.disabledStandardMetaClass()) {
            if (ScriptBytecodeAdapter.compareNotEqual(str, (Object) null)) {
                str = callSiteArr$getCallSiteArray[142].callConstructor(ObjectName.class, str);
            }
            str = null;
        } else {
            if (ScriptBytecodeAdapter.compareNotEqual(str, (Object) null)) {
                str = callSiteArr$getCallSiteArray[143].callConstructor(ObjectName.class, str);
            }
            str = null;
        }
        if (!BytecodeInterface8.isOrigZ() || __$stMC || BytecodeInterface8.disabledStandardMetaClass()) {
            boolean zCompareEqual = ScriptBytecodeAdapter.compareEqual(str, (Object) null);
            str2 = str;
            if (zCompareEqual) {
                Object objCall = callSiteArr$getCallSiteArray[144].call(MBeanUtil.class, objCallGetProperty, JMXConfigurator.class);
                Call = callSiteArr$getCallSiteArray[145].call(MBeanUtil.class, callSiteArr$getCallSiteArray[146].callGroovyObjectGetProperty(this), this, objCall);
                if (ScriptBytecodeAdapter.compareEqual((Object) Call, (Object) null)) {
                    callSite = callSiteArr$getCallSiteArray[147];
                    gStringImpl = new GStringImpl(new Object[]{objCall}, new String[]{"Failed to construct ObjectName for [", "]"});
                    callSite.callCurrent(this, gStringImpl);
                    return;
                }
                str2 = Call;
            }
        } else {
            boolean zCompareEqual2 = ScriptBytecodeAdapter.compareEqual(str, (Object) null);
            str2 = str;
            if (zCompareEqual2) {
                Object objCall2 = callSiteArr$getCallSiteArray[148].call(MBeanUtil.class, objCallGetProperty, JMXConfigurator.class);
                Call = callSiteArr$getCallSiteArray[149].call(MBeanUtil.class, callSiteArr$getCallSiteArray[150].callGroovyObjectGetProperty(this), this, objCall2);
                if (ScriptBytecodeAdapter.compareEqual((Object) Call, (Object) null)) {
                    callSite = callSiteArr$getCallSiteArray[151];
                    gStringImpl = new GStringImpl(new Object[]{objCall2}, new String[]{"Failed to construct ObjectName for [", "]"});
                    callSite.callCurrent(this, gStringImpl);
                    return;
                }
                str2 = Call;
            }
        }
        Object objCallGetProperty2 = callSiteArr$getCallSiteArray[152].callGetProperty(ManagementFactory.class);
        if (!DefaultTypeTransformation.booleanUnbox(callSiteArr$getCallSiteArray[153].call(MBeanUtil.class, objCallGetProperty2, str2))) {
            try {
                callSiteArr$getCallSiteArray[156].call(objCallGetProperty2, (JMXConfigurator) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[154].callConstructor(JMXConfigurator.class, ScriptBytecodeAdapter.createPojoWrapper((LoggerContext) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[155].callGroovyObjectGetProperty(this), LoggerContext.class), LoggerContext.class), objCallGetProperty2, str2), JMXConfigurator.class), str2);
            } catch (Exception e4) {
                callSiteArr$getCallSiteArray[157].callCurrent(this, "Failed to create mbean", e4);
            }
        }
    }

    public void logger(String str, Level level) {
        $getCallSiteArray();
        logger(str, level, ScriptBytecodeAdapter.createList(new Object[0]), null);
    }

    public void receiver(String str, Class cls, Closure closure) {
        CallSite callSite;
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        callSiteArr$getCallSiteArray[88].callCurrent(this, callSiteArr$getCallSiteArray[89].call(callSiteArr$getCallSiteArray[90].call("About to instantiate receiver of type [", callSiteArr$getCallSiteArray[91].callGetProperty(callSiteArr$getCallSiteArray[92].callGroovyObjectGetProperty(this))), "]"));
        ReceiverBase receiverBase = (ReceiverBase) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[93].call(cls), ReceiverBase.class);
        ScriptBytecodeAdapter.setProperty(callSiteArr$getCallSiteArray[94].callGroovyObjectGetProperty(this), (Class) null, receiverBase, CoreConstants.CONTEXT_SCOPE_VALUE);
        if (!BytecodeInterface8.isOrigZ() || __$stMC || BytecodeInterface8.disabledStandardMetaClass()) {
            if (ScriptBytecodeAdapter.compareNotEqual(closure, (Object) null)) {
                ComponentDelegate componentDelegate = (ComponentDelegate) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[95].callConstructor(ComponentDelegate.class, receiverBase), ComponentDelegate.class);
                ScriptBytecodeAdapter.setProperty(callSiteArr$getCallSiteArray[96].callGroovyObjectGetProperty(this), (Class) null, componentDelegate, CoreConstants.CONTEXT_SCOPE_VALUE);
                ScriptBytecodeAdapter.setGroovyObjectProperty(componentDelegate, ConfigurationDelegate.class, closure, "delegate");
                ScriptBytecodeAdapter.setGroovyObjectProperty(callSiteArr$getCallSiteArray[97].callGetProperty(Closure.class), ConfigurationDelegate.class, closure, "resolveStrategy");
                callSite = callSiteArr$getCallSiteArray[98];
                callSite.call(closure);
            }
        } else if (ScriptBytecodeAdapter.compareNotEqual(closure, (Object) null)) {
            ComponentDelegate componentDelegate2 = (ComponentDelegate) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[99].callConstructor(ComponentDelegate.class, receiverBase), ComponentDelegate.class);
            ScriptBytecodeAdapter.setProperty(callSiteArr$getCallSiteArray[100].callGroovyObjectGetProperty(this), (Class) null, componentDelegate2, CoreConstants.CONTEXT_SCOPE_VALUE);
            ScriptBytecodeAdapter.setGroovyObjectProperty(componentDelegate2, ConfigurationDelegate.class, closure, "delegate");
            ScriptBytecodeAdapter.setGroovyObjectProperty(callSiteArr$getCallSiteArray[101].callGetProperty(Closure.class), ConfigurationDelegate.class, closure, "resolveStrategy");
            callSite = callSiteArr$getCallSiteArray[102];
            callSite.call(closure);
        }
        try {
            callSiteArr$getCallSiteArray[103].call(receiverBase);
        } catch (RuntimeException e4) {
            callSiteArr$getCallSiteArray[104].callCurrent(this, callSiteArr$getCallSiteArray[105].call(callSiteArr$getCallSiteArray[106].call("Failed to start receiver of type [", callSiteArr$getCallSiteArray[107].call(cls)), "]"), e4);
        }
    }

    public void root(Level level, List<String> list) {
        CallSite callSite;
        CallSite callSite2;
        CallSite callSite3;
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        if (!BytecodeInterface8.isOrigZ() || __$stMC || BytecodeInterface8.disabledStandardMetaClass()) {
            if (ScriptBytecodeAdapter.compareEqual(level, (Object) null)) {
                callSite3 = callSiteArr$getCallSiteArray[43];
                callSite3.callCurrent(this, "Root logger cannot be set to level null");
            } else {
                callSite = callSiteArr$getCallSiteArray[44];
                callSite2 = callSiteArr$getCallSiteArray[45];
                callSite.callCurrent(this, callSite2.callGetProperty(InterfaceC0781b.class), level, list);
            }
        }
        if (ScriptBytecodeAdapter.compareEqual(level, (Object) null)) {
            callSite3 = callSiteArr$getCallSiteArray[46];
            callSite3.callCurrent(this, "Root logger cannot be set to level null");
        } else {
            callSite = callSiteArr$getCallSiteArray[47];
            callSite2 = callSiteArr$getCallSiteArray[48];
            callSite.callCurrent(this, callSite2.callGetProperty(InterfaceC0781b.class), level, list);
        }
    }

    public void scan(String str) {
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        ReconfigureOnChangeFilter reconfigureOnChangeFilter = (ReconfigureOnChangeFilter) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[0].callConstructor(ReconfigureOnChangeFilter.class), ReconfigureOnChangeFilter.class);
        callSiteArr$getCallSiteArray[1].call(reconfigureOnChangeFilter, callSiteArr$getCallSiteArray[2].callGroovyObjectGetProperty(this));
        if (DefaultTypeTransformation.booleanUnbox(str)) {
            try {
                Duration duration = (Duration) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[3].call(Duration.class, str), Duration.class);
                callSiteArr$getCallSiteArray[4].call(reconfigureOnChangeFilter, callSiteArr$getCallSiteArray[5].call(duration));
                callSiteArr$getCallSiteArray[6].callCurrent(this, callSiteArr$getCallSiteArray[7].call("Setting ReconfigureOnChangeFilter scanning period to ", duration));
            } catch (NumberFormatException e4) {
                callSiteArr$getCallSiteArray[8].callCurrent(this, callSiteArr$getCallSiteArray[9].call(callSiteArr$getCallSiteArray[10].call("Error while converting [", callSiteArr$getCallSiteArray[11].callGroovyObjectGetProperty(this)), "] to long"), e4);
            }
        }
        callSiteArr$getCallSiteArray[12].call(reconfigureOnChangeFilter);
        callSiteArr$getCallSiteArray[13].callCurrent(this, "Adding ReconfigureOnChangeFilter as a turbo filter");
        callSiteArr$getCallSiteArray[14].call(callSiteArr$getCallSiteArray[15].callGroovyObjectGetProperty(this), reconfigureOnChangeFilter);
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

    public String timestamp(String str, long j4) {
        CallSite callSite;
        CallSite callSite2;
        CallSite callSite3;
        CallSite callSite4;
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        if (!BytecodeInterface8.isOrigL() || !BytecodeInterface8.isOrigZ() || __$stMC || BytecodeInterface8.disabledStandardMetaClass()) {
            if (ScriptBytecodeAdapter.compareEqual(Long.valueOf(j4), -1)) {
                callSiteArr$getCallSiteArray[128].callCurrent(this, "Using current interpretation time, i.e. now, as time reference.");
                callSite4 = callSiteArr$getCallSiteArray[129];
                j4 = DefaultTypeTransformation.longUnbox(callSite4.call(System.class));
            } else {
                callSite = callSiteArr$getCallSiteArray[130];
                callSite2 = callSiteArr$getCallSiteArray[131];
                callSite3 = callSiteArr$getCallSiteArray[132];
                callSite.callCurrent(this, callSite2.call(callSite3.call("Using ", Long.valueOf(j4)), " as time reference."));
            }
        } else if (ScriptBytecodeAdapter.compareEqual(Long.valueOf(j4), -1)) {
            callSiteArr$getCallSiteArray[133].callCurrent(this, "Using current interpretation time, i.e. now, as time reference.");
            callSite4 = callSiteArr$getCallSiteArray[134];
            j4 = DefaultTypeTransformation.longUnbox(callSite4.call(System.class));
        } else {
            callSite = callSiteArr$getCallSiteArray[135];
            callSite2 = callSiteArr$getCallSiteArray[136];
            callSite3 = callSiteArr$getCallSiteArray[137];
            callSite.callCurrent(this, callSite2.call(callSite3.call("Using ", Long.valueOf(j4)), " as time reference."));
        }
        return (String) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[139].call((CachingDateFormatter) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[138].callConstructor(CachingDateFormatter.class, str), CachingDateFormatter.class), Long.valueOf(j4)), String.class);
    }

    public void turboFilter(Class cls, Closure closure) {
        CallSite callSite;
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        callSiteArr$getCallSiteArray[110].callCurrent(this, callSiteArr$getCallSiteArray[111].call(callSiteArr$getCallSiteArray[112].call("About to instantiate turboFilter of type [", callSiteArr$getCallSiteArray[113].callGetProperty(cls)), "]"));
        TurboFilter turboFilter = (TurboFilter) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[114].call(cls), TurboFilter.class);
        ScriptBytecodeAdapter.setProperty(callSiteArr$getCallSiteArray[115].callGroovyObjectGetProperty(this), (Class) null, turboFilter, CoreConstants.CONTEXT_SCOPE_VALUE);
        if (!BytecodeInterface8.isOrigZ() || __$stMC || BytecodeInterface8.disabledStandardMetaClass()) {
            if (ScriptBytecodeAdapter.compareNotEqual(closure, (Object) null)) {
                ComponentDelegate componentDelegate = (ComponentDelegate) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[116].callConstructor(ComponentDelegate.class, turboFilter), ComponentDelegate.class);
                ScriptBytecodeAdapter.setProperty(callSiteArr$getCallSiteArray[117].callGroovyObjectGetProperty(this), (Class) null, componentDelegate, CoreConstants.CONTEXT_SCOPE_VALUE);
                ScriptBytecodeAdapter.setGroovyObjectProperty(componentDelegate, ConfigurationDelegate.class, closure, "delegate");
                ScriptBytecodeAdapter.setGroovyObjectProperty(callSiteArr$getCallSiteArray[118].callGetProperty(Closure.class), ConfigurationDelegate.class, closure, "resolveStrategy");
                callSite = callSiteArr$getCallSiteArray[119];
                callSite.call(closure);
            }
        } else if (ScriptBytecodeAdapter.compareNotEqual(closure, (Object) null)) {
            ComponentDelegate componentDelegate2 = (ComponentDelegate) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[120].callConstructor(ComponentDelegate.class, turboFilter), ComponentDelegate.class);
            ScriptBytecodeAdapter.setProperty(callSiteArr$getCallSiteArray[121].callGroovyObjectGetProperty(this), (Class) null, componentDelegate2, CoreConstants.CONTEXT_SCOPE_VALUE);
            ScriptBytecodeAdapter.setGroovyObjectProperty(componentDelegate2, ConfigurationDelegate.class, closure, "delegate");
            ScriptBytecodeAdapter.setGroovyObjectProperty(callSiteArr$getCallSiteArray[122].callGetProperty(Closure.class), ConfigurationDelegate.class, closure, "resolveStrategy");
            callSite = callSiteArr$getCallSiteArray[123];
            callSite.call(closure);
        }
        callSiteArr$getCallSiteArray[124].call(turboFilter);
        callSiteArr$getCallSiteArray[125].callCurrent(this, "Adding aforementioned turbo filter to context");
        callSiteArr$getCallSiteArray[126].call(callSiteArr$getCallSiteArray[127].callGroovyObjectGetProperty(this), turboFilter);
    }

    public void logger(String str, Level level, List<String> list, Boolean bool) {
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        if (DefaultTypeTransformation.booleanUnbox(str)) {
            Logger logger = (Logger) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[49].call((LoggerContext) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[50].callGroovyObjectGetProperty(this), LoggerContext.class), str), Logger.class);
            callSiteArr$getCallSiteArray[51].callCurrent(this, callSiteArr$getCallSiteArray[52].call(new GStringImpl(new Object[]{str}, new String[]{"Setting level of logger [", "] to "}), level));
            ScriptBytecodeAdapter.setProperty(level, (Class) null, logger, "level");
            Reference reference = new Reference((Object) null);
            Iterator it = (Iterator) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[53].call(list), Iterator.class);
            while (it.hasNext()) {
                reference.set(it.next());
                Appender appender = (Appender) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[54].call(this.appenderList, new _logger_closure1(this, this, reference)), Appender.class);
                if (ScriptBytecodeAdapter.compareNotEqual(appender, (Object) null)) {
                    callSiteArr$getCallSiteArray[55].callCurrent(this, callSiteArr$getCallSiteArray[56].call(new GStringImpl(new Object[]{reference.get()}, new String[]{"Attaching appender named [", "] to "}), logger));
                    callSiteArr$getCallSiteArray[57].call(logger, appender);
                } else {
                    callSiteArr$getCallSiteArray[58].callCurrent(this, new GStringImpl(new Object[]{reference.get()}, new String[]{"Failed to find appender named [", "]"}));
                }
            }
            if (ScriptBytecodeAdapter.compareNotEqual(bool, (Object) null)) {
                ScriptBytecodeAdapter.setProperty(bool, (Class) null, logger, "additive");
                return;
            }
            return;
        }
        callSiteArr$getCallSiteArray[59].callCurrent(this, "No name attribute for logger");
    }

    public /* synthetic */ void super$1$wait(long j4, int i4) throws InterruptedException {
        wait(j4, i4);
    }
}
