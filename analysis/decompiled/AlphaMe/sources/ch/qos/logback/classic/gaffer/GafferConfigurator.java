package ch.qos.logback.classic.gaffer;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import ch.qos.logback.core.status.OnConsoleStatusListener;
import ch.qos.logback.core.util.ContextUtil;
import ch.qos.logback.core.util.OptionHelper;
import com.stepos.alphame.BuildConfig;
import groovy.lang.Binding;
import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;
import groovy.lang.MetaClass;
import groovy.lang.Reference;
import groovy.lang.Script;
import java.io.File;
import java.lang.ref.SoftReference;
import java.net.URL;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.customizers.ImportCustomizer;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.ArrayUtil;
import org.codehaus.groovy.runtime.BytecodeInterface8;
import org.codehaus.groovy.runtime.GStringImpl;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSite;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;
import org.codehaus.groovy.runtime.typehandling.DefaultTypeTransformation;

/* loaded from: classes.dex */
public class GafferConfigurator implements GroovyObject {
    private static /* synthetic */ SoftReference $callSiteArray = null;
    private static /* synthetic */ ClassInfo $staticClassInfo = null;
    private static final String DEBUG_SYSTEM_PROPERTY_KEY = "logback.debug";
    public static transient /* synthetic */ boolean __$stMC;
    public static /* synthetic */ long __timeStamp;
    public static /* synthetic */ long __timeStamp__239_neverHappen1396467705783;
    private LoggerContext context;
    private transient /* synthetic */ MetaClass metaClass;

    class _run_closure1 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference $callSiteArray;
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;
        private /* synthetic */ Reference dslScript;

        private static /* synthetic */ CallSiteArray $createCallSiteArray() {
            return new CallSiteArray(_run_closure1.class, new String[0]);
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
        public _run_closure1(Object obj, Object obj2, Reference reference) {
            super(obj, obj2);
            $getCallSiteArray();
            this.dslScript = reference;
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
            if (getClass() != _run_closure1.class) {
                return ScriptBytecodeAdapter.initMetaClass(this);
            }
            ClassInfo classInfo = $staticClassInfo;
            if (classInfo == null) {
                classInfo = ClassInfo.getClassInfo(getClass());
                $staticClassInfo = classInfo;
            }
            return classInfo.getMetaClass();
        }

        public Object doCall() {
            $getCallSiteArray();
            return doCall(null);
        }

        public Script getDslScript() {
            $getCallSiteArray();
            return (Script) ScriptBytecodeAdapter.castToType(this.dslScript.get(), Script.class);
        }

        public Object doCall(Object obj) {
            $getCallSiteArray();
            return this.dslScript.get();
        }
    }

    private static /* synthetic */ CallSiteArray $createCallSiteArray() {
        String[] strArr = new String[55];
        $createCallSiteArray_1(strArr);
        return new CallSiteArray(GafferConfigurator.class, strArr);
    }

    private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
        strArr[0] = "setMainWatchURL";
        strArr[1] = "informContextOfURLUsedForConfiguration";
        strArr[2] = "run";
        strArr[3] = "text";
        strArr[4] = "informContextOfURLUsedForConfiguration";
        strArr[5] = "toURL";
        strArr[6] = "toURI";
        strArr[7] = "run";
        strArr[8] = "text";
        strArr[9] = "<$constructor$>";
        strArr[10] = "setProperty";
        strArr[11] = "localHostName";
        strArr[12] = "<$constructor$>";
        strArr[13] = "addCompilationCustomizers";
        strArr[14] = "importCustomizer";
        strArr[15] = "addCompilationCustomizers";
        strArr[16] = "getProperty";
        strArr[17] = "isEmpty";
        strArr[18] = "equalsIgnoreCase";
        strArr[19] = "equalsIgnoreCase";
        strArr[20] = "addNewInstanceToContext";
        strArr[21] = "isEmpty";
        strArr[22] = "equalsIgnoreCase";
        strArr[23] = "equalsIgnoreCase";
        strArr[24] = "addNewInstanceToContext";
        strArr[25] = "addGroovyPackages";
        strArr[26] = "<$constructor$>";
        strArr[27] = "getFrameworkPackages";
        strArr[28] = "parse";
        strArr[29] = "<$constructor$>";
        strArr[30] = "mixin";
        strArr[31] = "metaClass";
        strArr[32] = "setContext";
        strArr[33] = "metaClass";
        strArr[34] = "run";
        strArr[35] = "<$constructor$>";
        strArr[36] = "addStarImports";
        strArr[37] = "addImports";
        strArr[38] = "name";
        strArr[39] = "addStaticStars";
        strArr[40] = "name";
        strArr[41] = "addStaticImport";
        strArr[42] = "name";
        strArr[43] = "addStaticImport";
        strArr[44] = "name";
        strArr[45] = "addStaticImport";
        strArr[46] = "name";
        strArr[47] = "addStaticImport";
        strArr[48] = "name";
        strArr[49] = "addStaticImport";
        strArr[50] = "name";
        strArr[51] = "addStaticImport";
        strArr[52] = "name";
        strArr[53] = "addStaticImport";
        strArr[54] = "name";
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
        __timeStamp__239_neverHappen1396467705783 = 0L;
        __timeStamp = 1396467705783L;
    }

    public GafferConfigurator(LoggerContext loggerContext) {
        $getCallSiteArray();
        this.metaClass = $getStaticMetaClass();
        this.context = (LoggerContext) ScriptBytecodeAdapter.castToType(loggerContext, LoggerContext.class);
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

    public static final String getDEBUG_SYSTEM_PROPERTY_KEY() {
        return DEBUG_SYSTEM_PROPERTY_KEY;
    }

    public /* synthetic */ MetaClass $getStaticMetaClass() {
        if (getClass() != GafferConfigurator.class) {
            return ScriptBytecodeAdapter.initMetaClass(this);
        }
        ClassInfo classInfo = $staticClassInfo;
        if (classInfo == null) {
            classInfo = ClassInfo.getClassInfo(getClass());
            $staticClassInfo = classInfo;
        }
        return classInfo.getMetaClass();
    }

    public LoggerContext getContext() {
        return this.context;
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

    public ImportCustomizer importCustomizer() {
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        Object objCallConstructor = callSiteArr$getCallSiteArray[35].callConstructor(ImportCustomizer.class);
        callSiteArr$getCallSiteArray[36].call(objCallConstructor, ArrayUtil.createArray("ch.qos.logback.core", new GStringImpl(new Object[]{"ch.qos.logback.core"}, new String[]{"", ".encoder"}), new GStringImpl(new Object[]{"ch.qos.logback.core"}, new String[]{"", ".read"}), new GStringImpl(new Object[]{"ch.qos.logback.core"}, new String[]{"", ".rolling"}), new GStringImpl(new Object[]{"ch.qos.logback.core"}, new String[]{"", ".status"}), "ch.qos.logback.classic.net"));
        callSiteArr$getCallSiteArray[37].call(objCallConstructor, callSiteArr$getCallSiteArray[38].callGetProperty(PatternLayoutEncoder.class));
        callSiteArr$getCallSiteArray[39].call(objCallConstructor, callSiteArr$getCallSiteArray[40].callGetProperty(Level.class));
        callSiteArr$getCallSiteArray[41].call(objCallConstructor, "off", callSiteArr$getCallSiteArray[42].callGetProperty(Level.class), "OFF");
        callSiteArr$getCallSiteArray[43].call(objCallConstructor, "error", callSiteArr$getCallSiteArray[44].callGetProperty(Level.class), "ERROR");
        callSiteArr$getCallSiteArray[45].call(objCallConstructor, "warn", callSiteArr$getCallSiteArray[46].callGetProperty(Level.class), "WARN");
        callSiteArr$getCallSiteArray[47].call(objCallConstructor, "info", callSiteArr$getCallSiteArray[48].callGetProperty(Level.class), "INFO");
        callSiteArr$getCallSiteArray[49].call(objCallConstructor, BuildConfig.BUILD_TYPE, callSiteArr$getCallSiteArray[50].callGetProperty(Level.class), "DEBUG");
        callSiteArr$getCallSiteArray[51].call(objCallConstructor, "trace", callSiteArr$getCallSiteArray[52].callGetProperty(Level.class), "TRACE");
        callSiteArr$getCallSiteArray[53].call(objCallConstructor, "all", callSiteArr$getCallSiteArray[54].callGetProperty(Level.class), "ALL");
        return (ImportCustomizer) ScriptBytecodeAdapter.castToType(objCallConstructor, ImportCustomizer.class);
    }

    public void informContextOfURLUsedForConfiguration(URL url) {
        $getCallSiteArray()[0].call(ConfigurationWatchListUtil.class, this.context, url);
    }

    public /* synthetic */ Object invokeMethod(String str, Object obj) {
        return getMetaClass().invokeMethod(this, str, obj);
    }

    public void run(URL url) {
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        if (__$stMC || BytecodeInterface8.disabledStandardMetaClass()) {
            callSiteArr$getCallSiteArray[1].callCurrent(this, url);
        } else {
            informContextOfURLUsedForConfiguration(url);
        }
        callSiteArr$getCallSiteArray[2].callCurrent(this, callSiteArr$getCallSiteArray[3].callGetProperty(url));
    }

    public void setContext(LoggerContext loggerContext) {
        this.context = loggerContext;
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
        return ScriptBytecodeAdapter.getGroovyObjectField(GafferConfigurator.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class));
    }

    public /* synthetic */ Object this$dist$invoke$1(String str, Object obj) {
        $getCallSiteArray();
        return ScriptBytecodeAdapter.invokeMethodOnCurrentN(GafferConfigurator.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class), ScriptBytecodeAdapter.despreadList(new Object[0], new Object[]{obj}, new int[]{0}));
    }

    public /* synthetic */ void this$dist$set$1(String str, Object obj) {
        $getCallSiteArray();
        ScriptBytecodeAdapter.setGroovyObjectField(obj, GafferConfigurator.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class));
    }

    public /* synthetic */ void super$1$wait(long j4) throws InterruptedException {
        wait(j4);
    }

    public void run(File file) {
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        callSiteArr$getCallSiteArray[4].callCurrent(this, callSiteArr$getCallSiteArray[5].call(callSiteArr$getCallSiteArray[6].call(file)));
        callSiteArr$getCallSiteArray[7].callCurrent(this, callSiteArr$getCallSiteArray[8].callGetProperty(file));
    }

    public /* synthetic */ void super$1$wait(long j4, int i4) throws InterruptedException {
        wait(j4, i4);
    }

    public void run(String str) {
        CallSite callSite;
        Object objCallCurrent;
        CallSite callSite2;
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        Binding binding = (Binding) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[9].callConstructor(Binding.class), Binding.class);
        callSiteArr$getCallSiteArray[10].call(binding, "hostname", callSiteArr$getCallSiteArray[11].callGetProperty(ContextUtil.class));
        Object objCallConstructor = callSiteArr$getCallSiteArray[12].callConstructor(CompilerConfiguration.class);
        if (__$stMC || BytecodeInterface8.disabledStandardMetaClass()) {
            callSite = callSiteArr$getCallSiteArray[13];
            objCallCurrent = callSiteArr$getCallSiteArray[14].callCurrent(this);
        } else {
            callSite = callSiteArr$getCallSiteArray[15];
            objCallCurrent = importCustomizer();
        }
        callSite.call(objCallConstructor, objCallCurrent);
        String str2 = (String) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[16].call(System.class, DEBUG_SYSTEM_PROPERTY_KEY), String.class);
        if (BytecodeInterface8.isOrigZ() && !__$stMC && !BytecodeInterface8.disabledStandardMetaClass()) {
            if (!DefaultTypeTransformation.booleanUnbox(callSiteArr$getCallSiteArray[21].call(OptionHelper.class, str2)) && !DefaultTypeTransformation.booleanUnbox(callSiteArr$getCallSiteArray[22].call(str2, "false")) && !DefaultTypeTransformation.booleanUnbox(callSiteArr$getCallSiteArray[23].call(str2, "null"))) {
                callSite2 = callSiteArr$getCallSiteArray[24];
                callSite2.call(OnConsoleStatusListener.class, this.context);
            }
        } else if (!DefaultTypeTransformation.booleanUnbox(callSiteArr$getCallSiteArray[17].call(OptionHelper.class, str2)) && !DefaultTypeTransformation.booleanUnbox(callSiteArr$getCallSiteArray[18].call(str2, "false")) && !DefaultTypeTransformation.booleanUnbox(callSiteArr$getCallSiteArray[19].call(str2, "null"))) {
            callSite2 = callSiteArr$getCallSiteArray[20];
            callSite2.call(OnConsoleStatusListener.class, this.context);
        }
        callSiteArr$getCallSiteArray[25].call(callSiteArr$getCallSiteArray[26].callConstructor(ContextUtil.class, this.context), callSiteArr$getCallSiteArray[27].call(this.context));
        Reference reference = new Reference((Script) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[28].call(callSiteArr$getCallSiteArray[29].callConstructor(GroovyShell.class, binding, objCallConstructor), str), Script.class));
        callSiteArr$getCallSiteArray[30].call(callSiteArr$getCallSiteArray[31].callGroovyObjectGetProperty((Script) reference.get()), ConfigurationDelegate.class);
        callSiteArr$getCallSiteArray[32].call((Script) reference.get(), this.context);
        ScriptBytecodeAdapter.setProperty(new _run_closure1(this, this, reference), (Class) null, callSiteArr$getCallSiteArray[33].callGroovyObjectGetProperty((Script) reference.get()), "getDeclaredOrigin");
        callSiteArr$getCallSiteArray[34].call((Script) reference.get());
    }
}
