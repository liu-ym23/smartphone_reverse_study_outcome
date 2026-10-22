package org.yaml.snakeyaml;

import org.yaml.snakeyaml.inspector.TagInspector;
import org.yaml.snakeyaml.inspector.UnTrustedTagInspector;

/* loaded from: classes5.dex */
public class LoaderOptions {
    private boolean allowDuplicateKeys = true;
    private boolean warnOnDuplicateKeys = true;
    private boolean wrappedToRootException = false;
    private int maxAliasesForCollections = 50;
    private boolean allowRecursiveKeys = false;
    private boolean processComments = false;
    private boolean enumCaseSensitive = true;
    private int nestingDepthLimit = 50;
    private int codePointLimit = 3145728;
    private boolean mergeOnCompose = false;
    private TagInspector tagInspector = new UnTrustedTagInspector();

    public final boolean getAllowRecursiveKeys() {
        return this.allowRecursiveKeys;
    }

    public final int getCodePointLimit() {
        return this.codePointLimit;
    }

    public final int getMaxAliasesForCollections() {
        return this.maxAliasesForCollections;
    }

    public final int getNestingDepthLimit() {
        return this.nestingDepthLimit;
    }

    public TagInspector getTagInspector() {
        return this.tagInspector;
    }

    public final boolean isAllowDuplicateKeys() {
        return this.allowDuplicateKeys;
    }

    public final boolean isEnumCaseSensitive() {
        return this.enumCaseSensitive;
    }

    public boolean isMergeOnCompose() {
        return this.mergeOnCompose;
    }

    public final boolean isProcessComments() {
        return this.processComments;
    }

    public final boolean isWarnOnDuplicateKeys() {
        return this.warnOnDuplicateKeys;
    }

    public final boolean isWrappedToRootException() {
        return this.wrappedToRootException;
    }

    public void setAllowDuplicateKeys(boolean z10) {
        this.allowDuplicateKeys = z10;
    }

    public void setAllowRecursiveKeys(boolean z10) {
        this.allowRecursiveKeys = z10;
    }

    public void setCodePointLimit(int i10) {
        this.codePointLimit = i10;
    }

    public void setEnumCaseSensitive(boolean z10) {
        this.enumCaseSensitive = z10;
    }

    public void setMaxAliasesForCollections(int i10) {
        this.maxAliasesForCollections = i10;
    }

    public void setMergeOnCompose(boolean z10) {
        this.mergeOnCompose = z10;
    }

    public void setNestingDepthLimit(int i10) {
        this.nestingDepthLimit = i10;
    }

    public LoaderOptions setProcessComments(boolean z10) {
        this.processComments = z10;
        return this;
    }

    public void setTagInspector(TagInspector tagInspector) {
        this.tagInspector = tagInspector;
    }

    public void setWarnOnDuplicateKeys(boolean z10) {
        this.warnOnDuplicateKeys = z10;
    }

    public void setWrappedToRootException(boolean z10) {
        this.wrappedToRootException = z10;
    }
}
