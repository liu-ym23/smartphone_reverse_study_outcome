package org.scilab.forge.jlatexmath;

/* loaded from: classes5.dex */
public class FormulaNotFoundException extends JMathTeXException {
    public FormulaNotFoundException(String str) {
        super("There's no predefined TeXFormula with the name '" + str + "' defined in 'PredefinedTeXFormulas.xml'!");
    }
}
