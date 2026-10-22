package ch.qos.logback.core.pattern;

/* loaded from: classes.dex */
public interface PostCompileProcessor<E> {
    void process(Converter<E> converter);
}
