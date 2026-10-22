package org.scilab.forge.jlatexmath;

/* loaded from: classes5.dex */
public class SymbolNotFoundException extends JMathTeXException {
    public SymbolNotFoundException(String str) {
        super("There's no symbol with the name '" + str + "' defined in 'TeXSymbols.xml'!");
    }
}
