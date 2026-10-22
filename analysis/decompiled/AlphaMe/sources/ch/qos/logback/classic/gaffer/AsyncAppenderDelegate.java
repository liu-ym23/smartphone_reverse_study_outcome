package ch.qos.logback.classic.gaffer;

import ch.qos.logback.core.Appender;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusManager;
import groovy.lang.Closure;
import groovy.lang.MetaClass;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Map;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.GStringImpl;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSite;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;

/* loaded from: classes.dex */
public class AsyncAppenderDelegate extends AppenderDelegate {
    private static /* synthetic */ SoftReference $callSiteArray;
    private static /* synthetic */ ClassInfo $staticClassInfo;
    public static transient /* synthetic */ boolean __$stMC;
    public static /* synthetic */ long __timeStamp;
    public static /* synthetic */ long __timeStamp__239_neverHappen1396467705967;
    private Map<String, Appender<?>> appendersByName;

    public class _closure1 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference $callSiteArray;
        private static /* synthetic */ ClassInfo $staticClassInfo;
        public static transient /* synthetic */ boolean __$stMC;

        private static /* synthetic */ CallSiteArray $createCallSiteArray() {
            String[] strArr = new String[1];
            $createCallSiteArray_1(strArr);
            return new CallSiteArray(_closure1.class, strArr);
        }

        private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
            strArr[0] = "name";
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
        public _closure1(Object obj, Object obj2) {
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
            if (getClass() != _closure1.class) {
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

        public Object doCall(Object obj) {
            return ScriptBytecodeAdapter.createMap(new Object[]{$getCallSiteArray()[0].callGetProperty(obj), obj});
        }
    }

    private static /* synthetic */ CallSiteArray $createCallSiteArray() {
        String[] strArr = new String[4];
        $createCallSiteArray_1(strArr);
        return new CallSiteArray(AsyncAppenderDelegate.class, strArr);
    }

    private static /* synthetic */ void $createCallSiteArray_1(String[] strArr) {
        strArr[0] = "collectEntries";
        strArr[1] = "addAppender";
        strArr[2] = "component";
        strArr[3] = "getAt";
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
        __timeStamp__239_neverHappen1396467705967 = 0L;
        __timeStamp = 1396467705967L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncAppenderDelegate(Appender appender, List<Appender<?>> list) {
        super(appender);
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        this.appendersByName = ScriptBytecodeAdapter.createMap(new Object[0]);
        this.appendersByName = (Map) ScriptBytecodeAdapter.castToType(callSiteArr$getCallSiteArray[0].call(list, new _closure1(this, this)), Map.class);
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

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate, ch.qos.logback.classic.gaffer.ComponentDelegate
    public /* synthetic */ MetaClass $getStaticMetaClass() {
        if (getClass() != AsyncAppenderDelegate.class) {
            return ScriptBytecodeAdapter.initMetaClass(this);
        }
        ClassInfo classInfo = $staticClassInfo;
        if (classInfo == null) {
            classInfo = ClassInfo.getClassInfo(getClass());
            $staticClassInfo = classInfo;
        }
        return classInfo.getMetaClass();
    }

    public void appenderRef(String str) {
        CallSite[] callSiteArr$getCallSiteArray = $getCallSiteArray();
        callSiteArr$getCallSiteArray[1].call(callSiteArr$getCallSiteArray[2].callGroovyObjectGetProperty(this), callSiteArr$getCallSiteArray[3].call(this.appendersByName, str));
    }

    public Map<String, Appender<?>> getAppendersByName() {
        return this.appendersByName;
    }

    public void setAppendersByName(Map<String, Appender<?>> map) {
        this.appendersByName = map;
    }

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate, ch.qos.logback.classic.gaffer.ComponentDelegate
    public /* synthetic */ void super$1$notifyAll() {
        notifyAll();
    }

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate, ch.qos.logback.classic.gaffer.ComponentDelegate
    public /* synthetic */ String super$1$toString() {
        return super.toString();
    }

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate, ch.qos.logback.classic.gaffer.ComponentDelegate
    public /* synthetic */ void super$1$wait() throws InterruptedException {
        wait();
    }

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate, ch.qos.logback.classic.gaffer.ComponentDelegate
    public /* synthetic */ void super$2$addInfo(String str, Throwable th) {
        super.addInfo(str, th);
    }

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate, ch.qos.logback.classic.gaffer.ComponentDelegate
    public /* synthetic */ void super$2$addStatus(Status status) {
        super.addStatus(status);
    }

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate, ch.qos.logback.classic.gaffer.ComponentDelegate
    public /* synthetic */ Context super$2$getContext() {
        return super.getContext();
    }

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate, ch.qos.logback.classic.gaffer.ComponentDelegate
    public /* synthetic */ StatusManager super$2$getStatusManager() {
        return super.getStatusManager();
    }

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate, ch.qos.logback.classic.gaffer.ComponentDelegate
    public /* synthetic */ void super$2$setContext(Context context) {
        super.setContext(context);
    }

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate
    public /* synthetic */ void super$3$cascadeFields(ComponentDelegate componentDelegate) {
        super.cascadeFields(componentDelegate);
    }

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate
    public /* synthetic */ Object super$3$getComponent() {
        return getComponent();
    }

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate
    public /* synthetic */ String super$3$getComponentName() {
        return super.getComponentName();
    }

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate
    public /* synthetic */ Object super$3$getProperty(String str) {
        return super.getProperty(str);
    }

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate
    public /* synthetic */ void super$3$methodMissing(String str, Object obj) {
        super.methodMissing(str, obj);
    }

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate
    public /* synthetic */ String super$3$parseNameArgument(Object obj) {
        return super.parseNameArgument(obj);
    }

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate
    public /* synthetic */ void super$3$propertyMissing(String str, Object obj) {
        super.propertyMissing(str, obj);
    }

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate
    public /* synthetic */ void super$3$setProperty(String str, Object obj) {
        super.setProperty(str, obj);
    }

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate
    public /* synthetic */ Object super$3$this$dist$get$2(String str) {
        return super.this$dist$get$2(str);
    }

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate
    public /* synthetic */ Object super$3$this$dist$invoke$2(String str, Object obj) {
        return super.this$dist$invoke$2(str, obj);
    }

    @Override // ch.qos.logback.classic.gaffer.AppenderDelegate
    public /* synthetic */ void super$3$this$dist$set$2(String str, Object obj) {
        super.this$dist$set$2(str, obj);
    }

    public /* synthetic */ MetaClass super$4$$getStaticMetaClass() {
        return super.$getStaticMetaClass();
    }

    public /* synthetic */ String super$4$getLabel() {
        return super.getLabel();
    }

    public /* synthetic */ Object super$4$super$3$this$dist$get$2(String str) {
        return super.super$3$this$dist$get$2(str);
    }

    public /* synthetic */ Object super$4$super$3$this$dist$invoke$2(String str, Object obj) {
        return super.super$3$this$dist$invoke$2(str, obj);
    }

    public /* synthetic */ void super$4$super$3$this$dist$set$2(String str, Object obj) {
        super.super$3$this$dist$set$2(str, obj);
    }

    public /* synthetic */ Object super$4$this$dist$get$3(String str) {
        return super.this$dist$get$3(str);
    }

    public /* synthetic */ Object super$4$this$dist$invoke$3(String str, Object obj) {
        return super.this$dist$invoke$3(str, obj);
    }

    public /* synthetic */ void super$4$this$dist$set$3(String str, Object obj) {
        super.this$dist$set$3(str, obj);
    }

    public /* synthetic */ Object this$dist$get$4(String str) {
        $getCallSiteArray();
        return ScriptBytecodeAdapter.getGroovyObjectField(AsyncAppenderDelegate.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class));
    }

    public /* synthetic */ Object this$dist$invoke$4(String str, Object obj) {
        $getCallSiteArray();
        return ScriptBytecodeAdapter.invokeMethodOnCurrentN(AsyncAppenderDelegate.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class), ScriptBytecodeAdapter.despreadList(new Object[0], new Object[]{obj}, new int[]{0}));
    }

    public /* synthetic */ void this$dist$set$4(String str, Object obj) {
        $getCallSiteArray();
        ScriptBytecodeAdapter.setGroovyObjectField(obj, AsyncAppenderDelegate.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class));
    }
}
