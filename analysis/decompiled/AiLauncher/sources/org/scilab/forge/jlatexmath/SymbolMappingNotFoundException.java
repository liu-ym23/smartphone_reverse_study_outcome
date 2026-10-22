package org.scilab.forge.jlatexmath;

/* loaded from: classes5.dex */
public class SymbolMappingNotFoundException extends JMathTeXException {
    public SymbolMappingNotFoundException(String str) {
        super("No mapping found for the symbol '" + str + "'! Insert a <SymbolMapping>-element in 'DefaultTeXFont.xml'.");
    }
}
