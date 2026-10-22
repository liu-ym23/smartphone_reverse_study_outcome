package org.yaml.snakeyaml.tokens;

/* loaded from: classes4.dex */
public enum Token$ID {
    Alias("<alias>"),
    Anchor("<anchor>"),
    BlockEnd("<block end>"),
    BlockEntry("-"),
    BlockMappingStart("<block mapping start>"),
    BlockSequenceStart("<block sequence start>"),
    Directive("<directive>"),
    DocumentEnd("<document end>"),
    DocumentStart("<document start>"),
    FlowEntry(","),
    FlowMappingEnd("}"),
    FlowMappingStart("{"),
    FlowSequenceEnd("]"),
    FlowSequenceStart("["),
    Key("?"),
    Scalar("<scalar>"),
    StreamEnd("<stream end>"),
    StreamStart("<stream start>"),
    Tag("<tag>"),
    Value(":"),
    /* JADX INFO: Fake field, exist only in values array */
    Whitespace("<whitespace>"),
    Comment("#"),
    /* JADX INFO: Fake field, exist only in values array */
    Error("<error>");


    /* renamed from: a, reason: collision with root package name */
    public final String f5535a;

    Token$ID(String str) {
        this.f5535a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f5535a;
    }
}
