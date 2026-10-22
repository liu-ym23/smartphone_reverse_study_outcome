package ch.qos.logback.classic.gaffer;

import ch.qos.logback.core.Appender;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.joran.action.ActionConst;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusManager;
import groovy.lang.MetaClass;
import java.lang.ref.SoftReference;
import java.util.List;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.GStringImpl;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSite;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;

/* loaded from: classes.dex */
public class AppenderDelegate extends ComponentDelegate {
    private static /* synthetic */ SoftReference $callSiteArray;
    private static /* synthetic */ ClassInfo $staticClassInfo;
    public static transient /* synthetic */ boolean __$stMC;
    public static /* synthetic */ long __timeStamp;
    public static /* synthetic */ long __timeStamp__239_neverHappen1396467705964;

    private static /* synthetic */ CallSiteArray $createCallSiteArray() {
        return new CallSiteArray(AppenderDelegate.class, new String[0]);
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
        __timeStamp__239_neverHappen1396467705964 = 0L;
        __timeStamp = 1396467705964L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppenderDelegate(Appender appender) {
        super(appender);
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

    @Override // ch.qos.logback.classic.gaffer.ComponentDelegate
    public /* synthetic */ MetaClass $getStaticMetaClass() {
        if (getClass() != AppenderDelegate.class) {
            return ScriptBytecodeAdapter.initMetaClass(this);
        }
        ClassInfo classInfo = $staticClassInfo;
        if (classInfo == null) {
            classInfo = ClassInfo.getClassInfo(getClass());
            $staticClassInfo = classInfo;
        }
        return classInfo.getMetaClass();
    }

    @Override // ch.qos.logback.classic.gaffer.ComponentDelegate
    public String getLabel() {
        $getCallSiteArray();
        return ActionConst.APPENDER_TAG;
    }

    @Override // ch.qos.logback.classic.gaffer.ComponentDelegate
    public /* synthetic */ void super$1$notifyAll() {
        notifyAll();
    }

    @Override // ch.qos.logback.classic.gaffer.ComponentDelegate
    public /* synthetic */ String super$1$toString() {
        return super.toString();
    }

    @Override // ch.qos.logback.classic.gaffer.ComponentDelegate
    public /* synthetic */ void super$1$wait() throws InterruptedException {
        wait();
    }

    @Override // ch.qos.logback.classic.gaffer.ComponentDelegate
    public /* synthetic */ void super$2$addInfo(String str, Throwable th) {
        super.addInfo(str, th);
    }

    @Override // ch.qos.logback.classic.gaffer.ComponentDelegate
    public /* synthetic */ void super$2$addStatus(Status status) {
        super.addStatus(status);
    }

    @Override // ch.qos.logback.classic.gaffer.ComponentDelegate
    public /* synthetic */ Context super$2$getContext() {
        return super.getContext();
    }

    @Override // ch.qos.logback.classic.gaffer.ComponentDelegate
    public /* synthetic */ StatusManager super$2$getStatusManager() {
        return super.getStatusManager();
    }

    @Override // ch.qos.logback.classic.gaffer.ComponentDelegate
    public /* synthetic */ void super$2$setContext(Context context) {
        super.setContext(context);
    }

    public /* synthetic */ MetaClass super$3$$getStaticMetaClass() {
        return super.$getStaticMetaClass();
    }

    public /* synthetic */ Object super$3$analyzeArgs(Object[] objArr) {
        return super.analyzeArgs(objArr);
    }

    public /* synthetic */ void super$3$cascadeFields(ComponentDelegate componentDelegate) {
        super.cascadeFields(componentDelegate);
    }

    public /* synthetic */ Object super$3$getComponent() {
        return getComponent();
    }

    public /* synthetic */ String super$3$getComponentName() {
        return super.getComponentName();
    }

    public /* synthetic */ List super$3$getFieldsToCascade() {
        return getFieldsToCascade();
    }

    public /* synthetic */ String super$3$getLabel() {
        return super.getLabel();
    }

    public /* synthetic */ String super$3$getLabelFistLetterInUpperCase() {
        return super.getLabelFistLetterInUpperCase();
    }

    public /* synthetic */ MetaClass super$3$getMetaClass() {
        return super.getMetaClass();
    }

    public /* synthetic */ Object super$3$getProperty(String str) {
        return super.getProperty(str);
    }

    public /* synthetic */ void super$3$injectParent(Object obj) {
        super.injectParent(obj);
    }

    public /* synthetic */ Object super$3$invokeMethod(String str, Object obj) {
        return super.invokeMethod(str, obj);
    }

    public /* synthetic */ void super$3$methodMissing(String str, Object obj) {
        super.methodMissing(str, obj);
    }

    public /* synthetic */ Class super$3$parseClassArgument(Object obj) {
        return super.parseClassArgument(obj);
    }

    public /* synthetic */ String super$3$parseNameArgument(Object obj) {
        return super.parseNameArgument(obj);
    }

    public /* synthetic */ void super$3$propertyMissing(String str, Object obj) {
        super.propertyMissing(str, obj);
    }

    public /* synthetic */ void super$3$setMetaClass(MetaClass metaClass) {
        super.setMetaClass(metaClass);
    }

    public /* synthetic */ void super$3$setProperty(String str, Object obj) {
        super.setProperty(str, obj);
    }

    public /* synthetic */ Object super$3$this$dist$get$2(String str) {
        return super.this$dist$get$2(str);
    }

    public /* synthetic */ Object super$3$this$dist$invoke$2(String str, Object obj) {
        return super.this$dist$invoke$2(str, obj);
    }

    public /* synthetic */ void super$3$this$dist$set$2(String str, Object obj) {
        super.this$dist$set$2(str, obj);
    }

    public /* synthetic */ Object this$dist$get$3(String str) {
        $getCallSiteArray();
        return ScriptBytecodeAdapter.getGroovyObjectField(AppenderDelegate.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class));
    }

    public /* synthetic */ Object this$dist$invoke$3(String str, Object obj) {
        $getCallSiteArray();
        return ScriptBytecodeAdapter.invokeMethodOnCurrentN(AppenderDelegate.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class), ScriptBytecodeAdapter.despreadList(new Object[0], new Object[]{obj}, new int[]{0}));
    }

    public /* synthetic */ void this$dist$set$3(String str, Object obj) {
        $getCallSiteArray();
        ScriptBytecodeAdapter.setGroovyObjectField(obj, AppenderDelegate.class, this, (String) ScriptBytecodeAdapter.castToType(new GStringImpl(new Object[]{str}, new String[]{"", ""}), String.class));
    }
}
