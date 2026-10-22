package ch.qos.logback.classic.boolex;

import ch.qos.logback.classic.spi.ILoggingEvent;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import java.lang.ref.SoftReference;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.GStringImpl;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSite;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;
import org.codehaus.groovy.runtime.typehandling.DefaultTypeTransformation;

/* loaded from: classes.dex */
public class EvaluatorTemplate implements IEvaluator, GroovyObject {
    private static /* synthetic */ SoftReference $callSiteArray;
    private static /* synthetic */ ClassInfo $staticClassInfo;
    public static transient /* synthetic */ boolean __$stMC;
    public static /* synthetic */ long __timeStamp;
    public static /* synthetic */ long __timeStamp__239_neverHappen1396467705870;
    private transient /* synthetic */ MetaClass metaClass;

    private static /* synthetic */ CallSiteArray $createCallSiteArray() {
        return new CallSiteArray(EvaluatorTemplate.class, new String[0]);
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
        __timeStamp__239_neverHappen1396467705870 = 0L;
        __timeStamp = 1396467705870L;
    }

    public EvaluatorTemplate() {
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

    public /* synthetic */ MetaClass $getStaticMetaClass() {
        if (getClass() != EvaluatorTemplate.class) {
            return ScriptBytecodeAdapter.initMetaClass(this);
        }
        ClassInfo classInfo = $staticClassInfo;
        if (classInfo == null) {
            classInfo = ClassInfo.getClassInfo(getClass());
            $staticClassInfo = classInfo;
        }
        return classInfo.getMetaClass();
    }

    @Override // ch.qos.logback.classic.boolex.IEvaluator
    public boolean doEvaluate(ILoggingEvent iLoggingEvent) {
        $getCallSiteArray();
        return DefaultTypeTransformation.booleanUnbox(iLoggingEvent);
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
        return ScriptBytecodeAdapter.getGroovyObjectField(EvaluatorTemplate.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class));
    }

    public /* synthetic */ Object this$dist$invoke$1(String str, Object obj) {
        $getCallSiteArray();
        return ScriptBytecodeAdapter.invokeMethodOnCurrentN(EvaluatorTemplate.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class), ScriptBytecodeAdapter.despreadList(new Object[0], new Object[]{obj}, new int[]{0}));
    }

    public /* synthetic */ void this$dist$set$1(String str, Object obj) {
        $getCallSiteArray();
        ScriptBytecodeAdapter.setGroovyObjectField(obj, EvaluatorTemplate.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class));
    }

    public /* synthetic */ void super$1$wait(long j4) throws InterruptedException {
        wait(j4);
    }

    public /* synthetic */ void super$1$wait(long j4, int i4) throws InterruptedException {
        wait(j4, i4);
    }
}
