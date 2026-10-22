package org.scilab.forge.jlatexmath;

/* loaded from: classes5.dex */
public class TextStyleMappingNotFoundException extends JMathTeXException {
    public TextStyleMappingNotFoundException(String str) {
        super("No mapping found for the text style '" + str + "'! Insert a <TextStyleMapping>-element in 'DefaultTeXFont.xml'.");
    }
}
