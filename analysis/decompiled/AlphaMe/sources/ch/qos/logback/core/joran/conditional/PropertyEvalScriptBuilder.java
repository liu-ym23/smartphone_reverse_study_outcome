package ch.qos.logback.core.joran.conditional;

import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.PropertyContainer;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.ClassBodyEvaluator;

/* loaded from: classes.dex */
public class PropertyEvalScriptBuilder extends ContextAwareBase {
    private static String SCRIPT_PREFIX = "public boolean evaluate() { return ";
    private static String SCRIPT_SUFFIX = "; }";
    final PropertyContainer localPropContainer;
    Map<String, String> map = new HashMap();

    public PropertyEvalScriptBuilder(PropertyContainer propertyContainer) {
        this.localPropContainer = propertyContainer;
    }

    public Condition build(String str) throws IllegalAccessException, CompileException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ClassBodyEvaluator classBodyEvaluator = new ClassBodyEvaluator();
        classBodyEvaluator.setImplementedInterfaces(new Class[]{Condition.class});
        classBodyEvaluator.setExtendedClass(PropertyWrapperForScripts.class);
        classBodyEvaluator.setParentClassLoader(ClassBodyEvaluator.class.getClassLoader());
        classBodyEvaluator.cook(SCRIPT_PREFIX + str + SCRIPT_SUFFIX);
        Class clazz = classBodyEvaluator.getClazz();
        Condition condition = (Condition) clazz.newInstance();
        clazz.getMethod("setPropertyContainers", PropertyContainer.class, PropertyContainer.class).invoke(condition, this.localPropContainer, this.context);
        return condition;
    }
}
